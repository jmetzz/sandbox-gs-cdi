package com.github.jmetzz.jms_lab.mdb_demo;


import com.github.jmetzz.jms_lab.pojo.CreditCard;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


@MessageDriven(
        mappedName = "jms/javaee7/Topic",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
                @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "validate = true")
        }
)
/*
* In case you prefer to let the JMS runtime create the JMS resources for you,
* just uncomment the next 2 lines :)
* Bear in mind that if you already have defined these resources in your glassfish instance,
* the deploy will fail.
**/
//@JMSConnectionFactoryDefinition(name = "jms/javaee7/ConnectionFactory", className = "javax.jms.ConnectionFactory")
//@JMSDestinationDefinition(name = "jms/javaee7/Topic", className = "javax.jms.Topic", interfaceName = "javax.jms.Topic")
public class ValidateCreditCardMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            CreditCard creditCard = message.getBody(CreditCard.class);
            System.out.println("Received credit card: " + creditCard);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
