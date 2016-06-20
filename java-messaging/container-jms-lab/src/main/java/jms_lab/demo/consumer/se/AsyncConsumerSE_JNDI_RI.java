package jms_lab.demo.consumer.se;


import jms_lab.demo.pojo.CreditCard;

import javax.annotation.Resource;
import javax.jms.*;
import javax.naming.NamingException;



public class AsyncConsumerSE_JNDI_RI implements MessageListener {

    @Resource(lookup = "jms/javaee7/ConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/javaee7/Topic")
    private static Topic topic;


    public static void main(String[] args) throws NamingException {
        try(JMSContext context = connectionFactory.createContext()){
            context.createConsumer(topic, "validate = true").setMessageListener(new AsyncConsumerSE_JNDI_RI());
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
