package com.github.jmetzz.jms_lab.standalone.simplified_api_demo;


import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
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


            // sends the message
            try (JMSContext context = connectionFactory.createContext()) {
                context.createProducer().send(queue, "Time now: " + new Date());
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

}
