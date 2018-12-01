package com.oristartech;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;




@SpringBootApplication
public class PrxSunxDemoDubboConsumerApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext application = SpringApplication.run(PrxSunxDemoDubboConsumerApplication.class, args);
//		RegistryService.getInstance().initial(application);
		
//		System.setProperty("java.net.preferIPv4Stack", "true");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-consumer.xml"});
//        context.start();
//
//        DemoService demoService = (DemoService) context.getBean("demoService"); // get remote service proxy
//
//        while (true) {
//            try {
//                Thread.sleep(1000);
//                String hello = demoService.sayHello("world"); // call remote method
//                System.out.println(hello); // get result
//
//            } catch (Throwable throwable) {
//                throwable.printStackTrace();
//            }
//
//
//        }
        
//        System.in.read(); // press any key to exit
	}
}
