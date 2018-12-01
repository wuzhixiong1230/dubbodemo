package prx.demo.dubbo.consumer;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.common.message.Message;

import prx.demo.dubbo.provider.transaction.TransactionMqProducer;
import prx.demo.dubbo.provider.util.SpringContextUtils;

public class TransactionProvider {

	public static void main(String[] args) throws MQClientException, InterruptedException {  
//		TransactionMqProducer.InitMqProducer("transaction_Producer","192.168.1.110:9876");
		TransactionMqProducer.InitMqProducer("transaction_Producer","122.14.208.111:9876;122.14.209.213:9876");
        TransactionCheckListener transactionCheckListener = new TransactionCheckListenerImpl();
    	TransactionMqProducer.producer.setTransactionCheckListener(transactionCheckListener);
    	
    	TransactionExecuterImpl tranExecuter = new TransactionExecuterImpl(); 
    	for (int i = 0; i < 10000; i++) {
	        Message msg = new Message("TopicTransactionTest", "transaction", "KEY",("cc"+i).getBytes());
	        Thread.sleep(1000);
	        SendResult sendResult = TransactionMqProducer.producer.sendMessageInTransaction(msg, tranExecuter, null);  
    	}
        for (int i = 0; i < 100000; i++) {  
            Thread.sleep(1000);  
        }  
  
        TransactionMqProducer.producer.shutdown();  
  
    }  
}
