package com.github.jmetzz.jms_lab.se;






import com.github.jmetzz.jms_lab.pojo.CreditCard;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.Message;


/**
 * Event driven message consumer.
 * Since this class implements an event model for handling message arrivals,
 * there is no need to look indefinitely ro receive a message.
 * MDBs use event model to handle message arrival by defining the callback onMessage,
 * which gets called every time a message is available to be handled.
 */
public class AsyncConsumer implements MessageListener {

    public static void main(String[] args) throws NamingException {
        Context jndiContext = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");

        try(JMSContext context = connectionFactory.createContext()){
            context.createConsumer(topic, "validate = true").setMessageListener(new AsyncConsumer());
        }
    }


    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Async Message received: " + message.getBody(CreditCard.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
