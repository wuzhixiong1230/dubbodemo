package prx.demo.dubbo.provider.transaction;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.MessageListener;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;

import prx.sunx.dubbo.serviceApi.DubboService;

public class TransactionMqConsumer {
	
	@Autowired
	DubboService dubboService;
	
	public static DefaultMQPushConsumer consumer;
	
	public static void initMqConsumer(MessageListener messageListener,String consumerGroup,String topic,String addr) throws MQClientException{
		consumer = new DefaultMQPushConsumer(consumerGroup);  
        consumer.setNamesrvAddr(addr);  
        consumer.setConsumeMessageBatchMaxSize(10);  
        /** 
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br> 
         * 如果非第一次启动，那么按照上次消费的位置继续消费 
         */  
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);  
  
        consumer.subscribe(topic, "*");  
  
        consumer.registerMessageListener(messageListener);  
  
        consumer.start();
	}
}
