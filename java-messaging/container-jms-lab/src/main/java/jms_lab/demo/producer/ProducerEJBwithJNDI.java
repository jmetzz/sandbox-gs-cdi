package jms_lab.demo.producer;

import jms_lab.demo.pojo.CreditCard;
import jms_lab.demo.pojo.CreditCardType;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;

@Stateless
public class ProducerEJBwithJNDI {

    @Resource(lookup = "jms/javaee7/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/javaee7/Topic")
    private Topic topic;

    CreditCard creditCard1 = new CreditCard("12345", "2020-01-01", 123, CreditCardType.MASTER_CARD);
    CreditCard creditCard2 = new CreditCard("67891", "2023-05-01", 456, CreditCardType.MASTER_CARD);

    public void sendMessage(){
        try(JMSContext context = connectionFactory.createContext()){
            context.createProducer().setProperty("validate", true).send(topic, creditCard1);
            System.out.println("Credit card sent: " + creditCard1);

            context.createProducer().setProperty("validate", false).send(topic, creditCard2);
            System.out.println("Credit card sent: " + creditCard2);
        }
    }

}
