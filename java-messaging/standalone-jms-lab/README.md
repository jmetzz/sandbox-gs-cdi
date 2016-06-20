To run these examples you must have GlassFish running and create the following administered objects :

. jms/javaee7/Queue
. jms/javaee7/ConnectionFactory


To manage JMS connection factories using the command-line utility, use create-jms-resource, list-jms-resources, or delete-jms-resource command

> create-jms-resource --restype javax.jms.ConnectionFactory jms/javaee7/ConnectionFactory
> create-jms-resource --restype javax.jms.Queue jms/javaee7/Queue

asadmin> list-jms-resources
jms/javaee7/Queue
jms/javaee7/ConnectionFactory

Then just run both JmsTextMsgProducer and JmsTextMsgConsumer to see messages flow.
Be aware that the produce class only sends one message and ends its processing, while the consumer keeps a loop waiting for new messages to be printed.
Therefore, you will get as many messages as the times you run the producer.