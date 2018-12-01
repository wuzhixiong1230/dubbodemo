package prx.demo.dubbo.provider.transaction;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;

public class TransactionMqProducer {

	public static TransactionMQProducer producer;
	
	public static void InitMqProducer(String producerGroup,String addr) throws MQClientException{
		producer = new TransactionMQProducer(producerGroup);  
        producer.setNamesrvAddr(addr);  
        // 事务回查最小并发数  
        producer.setCheckThreadPoolMinSize(2);  
        // 事务回查最大并发数  
        producer.setCheckThreadPoolMaxSize(2);  
        // 队列数  
        producer.setCheckRequestHoldMax(2000);  
//        producer.setTransactionCheckListener(transactionCheckListener);  
        producer.start(); 
	}
}
