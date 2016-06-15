package com.github.jmetzz.jms_lab.simplified_api_demo;

import com.github.jmetzz.jms_lab.simplified_api_demo.pojo.CreditCard;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Jean Metz.
 */
public class JmsCreditCardMsgConsumer {


    public static void main(String[] args) throws NamingException {

        // Gets the JNDI context
        Context jndiContext = new InitialContext();

        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Queue");

        // Loops to receive the messages
        System.out.println("\nInfinite loop. Waiting for a message...");
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            while (true) {
                CreditCard creditCard = jmsContext.createConsumer(topic).receiveBody(CreditCard.class);
                System.out.println("Credit card received: \n" + creditCard);
            }
        }

    }
}
