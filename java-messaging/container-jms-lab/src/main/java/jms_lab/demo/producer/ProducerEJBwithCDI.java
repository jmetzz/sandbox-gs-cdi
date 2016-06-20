package jms_lab.demo.producer;

import jms_lab.demo.pojo.CreditCard;
import jms_lab.demo.pojo.CreditCardType;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.logging.Logger;

@Stateless
public class ProducerEJBwithCDI {

    private static Logger logger = Logger.getLogger(ProducerEJBwithCDI.class.getName());

    @Inject
    @JMSConnectionFactory("jms/javaee7/ConnectionFactory")
    /* In case you have secured your resources, you can access them as */
    // @JMSPasswordCredential(userName="admin",password="mypassword")
    private JMSContext context;

    @Resource(lookup = "jms/javaee7/Queue")
    private Topic topic;

    CreditCard creditCard = new CreditCard("12345", "2020-01-01", 123, CreditCardType.MASTER_CARD);

    public void sendMessage() {
        context.createProducer().setProperty("validate", true).send(topic, creditCard);
        logger.info("Credit card sent to queue: " + creditCard);
    }

}
