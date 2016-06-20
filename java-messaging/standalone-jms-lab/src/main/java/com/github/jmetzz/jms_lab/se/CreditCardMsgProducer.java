package com.github.jmetzz.jms_lab.se;

import com.github.jmetzz.jms_lab.pojo.CreditCard;
import com.github.jmetzz.jms_lab.pojo.CreditCardType;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Jean Metz.
 */
public class CreditCardMsgProducer {


    public static void main(String[] args) throws NamingException {


        // Gets the JNDI context
        Context jndiContext = new InitialContext();

        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination queue = (Destination) jndiContext.lookup("jms/javaee7/Topic");

        CreditCard creditCard = new CreditCard("12345", "2020-01-01", 123, CreditCardType.MASTER_CARD);

        // Loops to receive the messages
        System.out.println("\nInfinite loop. Waiting for a message...");
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.createProducer().setProperty("validate", true).send(queue, creditCard);
            System.out.println("Credit card sent: " + creditCard);
        }

    }
}
