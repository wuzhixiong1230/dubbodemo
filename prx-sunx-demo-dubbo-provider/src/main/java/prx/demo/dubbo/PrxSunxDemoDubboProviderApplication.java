package prx.demo.dubbo;

import java.io.IOException;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.rocketmq.client.exception.MQClientException;

import prx.demo.dubbo.provider.util.SpringContextUtils;

//@EnableTransactionManagement
@SpringBootApplication
//@MapperScan("prx.demo.dubbo.provider.dao")
//@ImportResource({ "dubbo-provider.xml","bytejta-supports-dubbo.xml" })
//@ImportResource(value = {"classpath:dubbo-provider.xml"})
//@ComponentScan(basePackages = { "prx.demo.dubbo"})
public class PrxSunxDemoDubboProviderApplication {

	public static void main(String[] args) throws IOException, MQClientException {
		ApplicationContext application = SpringApplication.run(PrxSunxDemoDubboProviderApplication.class, args);
		SpringContextUtils.setApplicationContext(application);
		
//		TransactionMqProducer.InitMqProducer("transaction_Producer","192.168.101.121:9876");
		
//		TransactionMqConsumer.initMqConsumer(application.getBean(DubboConsumer.class),"transaction_Consumer","TopicTransactionTest","192.168.101.121:9876");
		//Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
//        System.setProperty("java.net.preferIPv4Stack", "true");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-provider.xml"});
//        context.start();
//
//        System.in.read(); // press any key to exit
        
//		RegistryService.getInstance().initial(application);
		
//		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//	         public void run() {
//	        	 TransactionMqProducer.producer.shutdown();
//	        	 TransactionMqConsumer.consumer.shutdown();
//	          }
//	       }));
//	       System.exit(0);
	}


}
