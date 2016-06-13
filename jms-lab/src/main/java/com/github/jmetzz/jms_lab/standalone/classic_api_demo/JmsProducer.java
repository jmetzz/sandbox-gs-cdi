package com.github.jmetzz.jms_lab.standalone.classic_api_demo;


import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;


public class JmsProducer {

    public static void main(String[] args) {
        try {
            // Gets the JNDI context
            Context jndiContext = new InitialContext();

            // Fetch administered resources
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/jmsLab/ConnectionFactory");
            Destination queue = (Destination) jndiContext.lookup("jms/jmsLab/Queue");

            Connection conn = connectionFactory.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);

            // sends the message
            TextMessage message = session.createTextMessage("Time now: " + new Date());
            producer.send(message);

        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }

}
