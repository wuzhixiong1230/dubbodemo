package prx.demo.dubbo.provider.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;

import prx.sunx.dubbo.serviceApi.DubboService;

@Component
public class DubboConsumer implements MessageListenerConcurrently {

	@Autowired
	private DubboService dubboService;
	
	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		
		try {  
            for (MessageExt msg : msgs) {  
                System.out.println(msg + ",内容：" + new String(msg.getBody()));
                dubboService.transction2();
            }  
            
        } catch (Exception e) {
//		如果多次回滚,可以根据回滚次数考虑人工干预,或者把之前的业务进行反向操作
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;// 重试  
        }  

        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;// 成功  
	}

}
