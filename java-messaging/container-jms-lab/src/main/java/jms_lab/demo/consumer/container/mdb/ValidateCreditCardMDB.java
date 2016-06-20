package jms_lab.demo.consumer.container.mdb;


import jms_lab.demo.pojo.CreditCard;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;


@MessageDriven(
   mappedName = "jms/javaee7/Topic",
   activationConfig = {
       @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
       @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "validate = true")
   }
)
@JMSConnectionFactoryDefinition(name = "jms/javaee7/ConnectionFactory", className = "javax.jms.ConnectionFactory" )
@JMSDestinationDefinition(name = "jms/javaee7/Topic", className = "javax.jms.Topic", interfaceName = "javax.jms.Topic")
public class ValidateCreditCardMDB implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try{
            CreditCard creditCard = message.getBody(CreditCard.class);
            System.out.println("Received credit card: " + creditCard);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
