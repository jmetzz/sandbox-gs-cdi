package com.github.jmetzz.jms_lab.se;

import com.github.jmetzz.jms_lab.pojo.CreditCard;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Jean Metz.
 */
public class CreditCardMsgConsumer {


    public static void main(String[] args) throws NamingException {

        // Gets the JNDI context
        Context jndiContext = new InitialContext();

        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination queue = (Destination) jndiContext.lookup("jms/javaee7/Queue");

        // Loops to receive the messages
        System.out.println("\nInfinite loop. Waiting for a message...");
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            JMSConsumer consumer = jmsContext.createConsumer(queue);

            while (true) {
                CreditCard creditCard = consumer.receiveBody(CreditCard.class);
                System.out.println("Credit card received: \n" + creditCard);
            }
        }

    }
}
