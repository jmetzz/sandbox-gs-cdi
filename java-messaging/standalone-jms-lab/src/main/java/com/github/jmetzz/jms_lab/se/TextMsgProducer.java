package com.github.jmetzz.jms_lab.se;


import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;


public class TextMsgProducer {

    public static void main(String[] args) throws NamingException {
        // Gets the JNDI context
        Context jndiContext = new InitialContext();

        // Fetch administered resources
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination queue = (Destination) jndiContext.lookup("jms/javaee7/Queue");

        // sends the message
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(queue, "Time now: " + new Date());
        }

    }

}
