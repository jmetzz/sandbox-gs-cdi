package com.github.jmetzz.jms_lab.container;





import com.github.jmetzz.jms_lab.pojo.CreditCard;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;

@Stateless
public class SyncConsumerCDI {

    @Inject
    @JMSConnectionFactory("jms/javaee7/ConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "jms/javaee7/Topic")
    Topic topic;

    public void receive() {
        JMSConsumer consumer = context.createConsumer(topic, "validate = true");
        while (true) {
            CreditCard creditCard = consumer.receiveBody(CreditCard.class);
            System.out.println(creditCard);
        }
    }
}
