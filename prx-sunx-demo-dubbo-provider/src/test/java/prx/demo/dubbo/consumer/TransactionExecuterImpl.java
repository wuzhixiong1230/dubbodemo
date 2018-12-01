package prx.demo.dubbo.consumer;

import java.net.SocketAddress;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelConfig;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.local.LocalAddress;
import org.jboss.netty.channel.local.LocalServerChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.common.message.Message;


@Component
public class TransactionExecuterImpl implements LocalTransactionExecuter, LocalServerChannel {

	
	@Override
	public ChannelFuture bind(SocketAddress arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelFuture close() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelFuture connect(SocketAddress arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelFuture disconnect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelFuture getCloseFuture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelConfig getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInterestOps() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Channel getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelPipeline getPipeline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWritable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ChannelFuture setInterestOps(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelFuture setReadable(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelFuture unbind() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelFuture write(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChannelFuture write(Object arg0, SocketAddress arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Channel o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LocalAddress getLocalAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalAddress getRemoteAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
//		本地事务的幂等性则需要再次验证，因为消息生产者无法识别业务是否重复提交，则需要在此进行业务幂等性验证
		
		System.out.println("执行本地事务msg = " + new String(msg.getBody()) + " 信息：" + msg);  
		  
        System.out.println("执行本地事务arg = " + arg);  
		
//		try {
//			dubboService.dubboEcho(new String(msg.getBody()));
//		} catch (Exception e) {
//			System.out.println("======我的操作============，失败了  -进行ROLLBACK");  
//            return LocalTransactionState.ROLLBACK_MESSAGE; 
//		}
		
//        String tags = msg.getTags();  
  
//        if (tags.equals("transaction2")) {  
//             
//        }  
        return LocalTransactionState.COMMIT_MESSAGE; 
	}

}
