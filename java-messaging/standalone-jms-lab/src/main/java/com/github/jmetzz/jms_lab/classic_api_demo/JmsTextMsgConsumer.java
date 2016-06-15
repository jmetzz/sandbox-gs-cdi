package com.github.jmetzz.jms_lab.classic_api_demo;


import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsTextMsgConsumer {

    public static void main(String[] args) {
        try {
            // Gets the JNDI context
            Context jndiContext = new InitialContext();

            // Fetch administered resources
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
            Destination queue = (Destination) jndiContext.lookup("jms/javaee7/Queue");

            Connection conn = connectionFactory.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(queue);

            conn.start();

            System.out.println("\nInfinite loop. Waiting for a message...");
            while(true){
                TextMessage message = (TextMessage) consumer.receive();
                System.out.println(message);
            }

        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }

}
