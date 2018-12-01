package prx.demo.dubbo.consumer;

import java.util.Calendar;
import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

import prx.demo.dubbo.provider.transaction.TransactionMqProducer;

public class TransctionConsumer2 {

	public static void main(String[] args) throws InterruptedException, MQClientException {
		StringBuffer hqlx = new StringBuffer();
		hqlx.append("aaa#12aaaaa");
		StringBuffer hql1 = new StringBuffer();
		hql1.append("bbb");
		int i = hqlx.indexOf("#12");
		hqlx.replace(i,	i+3, hql1.toString());
		System.out.println(hqlx.toString());
		
		StringBuffer a = new StringBuffer();
		a.append("aaa");
		StringBuffer b = new StringBuffer();
		b.append("b");
		b.append(a);
		a=b;
		System.out.println(a.toString());
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("transaction_Consumer");  
//        consumer.setNamesrvAddr("192.168.1.110:9876");  
        consumer.setNamesrvAddr("122.14.208.111:9876;122.14.209.213:9876"); 
        consumer.setConsumeMessageBatchMaxSize(10);  
        /** 
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br> 
         * 如果非第一次启动，那么按照上次消费的位置继续消费 
         */  
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);  
        consumer.setSuspendCurrentQueueTimeMillis(4000L);
        consumer.subscribe("TopicTransactionTest", "*");  
//        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.registerMessageListener(new MessageListenerConcurrently() {  
  
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {  
  
                try {  
  
                    for (MessageExt msg : msgs) {  
                        System.out.println("内容：" + new String(msg.getBody())+"  "+Calendar.getInstance().getTime() + " 信息：" + msg );  
//                        if("Hello RocketMQ 1".equalsIgnoreCase(new String(msg.getBody())))
//                        	throw new Exception();
                        if(msg.getReconsumeTimes() >= 0){
                        	System.out.println("所有事务执行完毕");
                        	return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                        }
                    }  
                    
                } catch (Exception e) {  
                    e.printStackTrace();  
  
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;// 重试  
  
                }  
                
                
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;// 成功  
            }  
        });  
  
        consumer.start();  
  
        System.out.println("transaction_Consumer2 Started.");  
    }  
}
