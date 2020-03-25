# rabbitmq-practise #
springboot-rabbitmq整合（MySQL数据库做数据源）

记录：
direct： 直连模式 1对1式，![](https://images2018.cnblogs.com/blog/174578/201805/174578-20180524175810062-1941410843.png)
发送、接收端配置相同queue名即可

topic： 转发模式 ![](https://images2018.cnblogs.com/blog/174578/201805/174578-20180524175844359-92574693.png) 
可根据通配符进行匹配，发送到相匹配的queue消息队列中。 * 代表匹配一个词，# 代表匹配多个词。例如 news.* 可以匹配news.game 、news.fashion 但不能匹配 news.game.lol 但news.# 是可以全部匹配的

fanout： 广播 ![](https://images2018.cnblogs.com/blog/174578/201805/174578-20180524175832191-777772730.png)
凡是与该发送源相同交换机（Exchange）订阅的频道，在发送源发送出一条消息后，都能接收到消息。因此在发送消息时，不用指定queue名，用 "" 代替
amqp.convertAndSend("fanoutExchange","",myUser.getId());

*项目运行出现的问题

Caused by: com.rabbitmq.client.ShutdownSignalException: channel error; protocol method: #method<channel.close>(reply-code=404, reply-text=NOT_FOUND - no queue 'topic.messages' in vhost '/', class-id=50, method-id=10)
	at com.rabbitmq.client.impl.ChannelN.asyncShutdown(ChannelN.java:516) ~[amqp-client-5.4.3.jar:5.4.3]
	at com.rabbitmq.client.impl.ChannelN.processAsync(ChannelN.java:346) ~[amqp-client-5.4.3.jar:5.4.3]
	at com.rabbitmq.client.impl.AMQChannel.handleCompleteInboundCommand(AMQChannel.java:178) ~[amqp-client-5.4.3.jar:5.4.3]
	at com.rabbitmq.client.impl.AMQChannel.handleFrame(AMQChannel.java:111) ~[amqp-client-5.4.3.jar:5.4.3]
	at com.rabbitmq.client.impl.AMQConnection.readFrame(AMQConnection.java:670) ~[amqp-client-5.4.3.jar:5.4.3]
	at com.rabbitmq.client.impl.AMQConnection.access$300(AMQConnection.java:48) ~[amqp-client-5.4.3.jar:5.4.3]
	at com.rabbitmq.client.impl.AMQConnection$MainLoop.run(AMQConnection.java:597) ~[amqp-client-5.4.3.jar:5.4.3]
	... 1 common frames omitted

启动receiver过程中报错，大致意思是mq中找不到topic.messages 这个队列。

解决：在启动sender 后，需要手动调用接口，往队列里发送几条消息，mq才能产生队列，否则及时启动了，但没发送消息，mq里依然是空
