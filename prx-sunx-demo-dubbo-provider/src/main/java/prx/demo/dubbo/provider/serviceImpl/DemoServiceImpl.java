package prx.demo.dubbo.provider.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Reference;

import prx.sunx.dubbo.serviceApi.DemoService;
import prx.sunx.dubbo.serviceApi.DubboService;
import prx.sunx.dubbo.serviceApi.EchoService;


/**
 * <p>
 * Created by sunx on 2017/9/19.
 * Description:
 */
//@Component
@com.alibaba.dubbo.config.annotation.Service
//@Service
public class DemoServiceImpl  implements DemoService{

	@Autowired
	private DubboService dubboService;
	
	@Reference
	private EchoService echoService;
	
//	@Transactional(rollbackFor = Exception.class)
    public String sayHello(String name) throws Exception {
    	
//    	TransactionCheckListener transactionCheckListener = new TransactionCheckListenerImpl();
//    	TransactionMqProducer.producer.setTransactionCheckListener(transactionCheckListener);
//    	
//    	TransactionExecuterImpl tranExecuter = SpringContextUtils.getBean(TransactionExecuterImpl.class);  
//        Message msg = new Message("TopicTransactionTest", "transaction", "KEY",("guangzhou").getBytes());
//        SendResult sendResult = TransactionMqProducer.producer.sendMessageInTransaction(msg, tranExecuter, null);  
//        System.out.println(sendResult);  
  
    	System.out.println(name);
        return echoService.echo(name);
//    	return dubboService.dubboEcho(name);
    }
}
