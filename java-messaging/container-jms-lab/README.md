To run these examples you must have GlassFish running and create the following administered objects :

. jms/javaee7/Queue
. jms/javaee7/Topic
. jms/javaee7/ConnectionFactory


To manage JMS connection factories using the command-line utility, use create-jms-resource, list-jms-resources, or delete-jms-resource command

> create-jms-resource --restype javax.jms.ConnectionFactory jms/javaee7/ConnectionFactory
> create-jms-resource --restype javax.jms.Queue jms/javaee7/Queue
> create-jms-resource --restype javax.jms.Topic jms/javaee7/Topic

asadmin> list-jms-resources
jms/javaee7/Queue
jms/javaee7/Topic
jms/javaee7/ConnectionFactory

After building with Maven, deploy the MDB with the following command
> asadmin deploy <component name>.jar

If the deployment is successful, the following command should return the name of the deployed jar
> asadmin list-components


Run the examples with the appclient commannd :

appclient -client chapter13-1.0.jar
If you need to empty a destination (flush all messages), this is what you need to do (the name of the destination is the physical name, not the JNDI name) :

asadmin flush-jmsdest --desttype queue jms_javaee7_Queue asadmin flush-jmsdest --desttype topic jms_javaee7_Topic


!!! Warning !!! These examples use the new lookup attribute of the @Resource annotation (Commons Annotation 1.1). Because the 1.0 is bundled into the JDK, you need to endorse it : copy the %M2_REPO%\org\glassfish\javax.annotation\${glassfish-version}\javax.annotation-${glassfish-version}.jar to the %JAVA_HOME%\lib\endorsed (in the JRE_HOME if needed too)