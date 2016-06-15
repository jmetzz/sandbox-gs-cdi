package com.github.jmetzz.jms_lab.simplified_api_demo;


import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsTextMsgConsumer {

    public static void main(String[] args) throws NamingException {
        // Gets the JNDI context
        Context jndiContext = new InitialContext();

        // Fetch administered resources
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination queue = (Destination) jndiContext.lookup("jms/javaee7/Queue");

      /*  Connection conn = connectionFactory.createConnection();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        conn.start();*/

        // sends the message
        try (JMSContext context = connectionFactory.createContext()) {
            System.out.println("\nInfinite loop. Waiting for a message...");
            while (true) {
                System.out.println(context.createConsumer(queue).receiveBody(String.class));
            }
        }

    }

}
