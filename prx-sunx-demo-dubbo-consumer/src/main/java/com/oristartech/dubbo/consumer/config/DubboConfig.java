package com.oristartech.dubbo.consumer.config;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.oristartech.dubbo.consumer.servicePro.TestDubbo;

import prx.sunx.dubbo.serviceApi.DemoService;

/**
 * <p>
 * Created by sunx on 2017/9/21.
 * Description:
 */
@Component
public class DubboConfig implements CommandLineRunner{

	public static List<Object> sl = new ArrayList<>();
	
	public void run(String... args) throws Exception {
//		System.out.println("dddddddddddddddddddddddddddddd");
//		
//		ApplicationConfig application = new ApplicationConfig();
//		application.setName("prx-sunx-demo-dubbo-consumer");
//		
//		// 连接注册中心配置
//		RegistryConfig registry = new RegistryConfig();
//		registry.setAddress("zookeeper://127.0.0.1:2181");
////		registry.setUsername("root");
////		registry.setPassword("root");
//
//		// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
//
//		// 引用远程服务
//		ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
//		reference.setApplication(application);
//		reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
//		reference.setInterface(DemoService.class);
//		reference.setVersion("1.0.0");
//
//		
////		// 方法级配置
////		List<MethodConfig> methods = new ArrayList<MethodConfig>();
////		MethodConfig method = new MethodConfig();
////		method.setName("sayHello");
////		method.setTimeout(10000);
////		method.setRetries(0);
////		methods.add(method);
////
////		// 引用远程服务
////		reference.setMethods(methods); // 设置方法级配置
//		DemoService s = reference.get();
//		
//		String aa = "com.oristartech.dubbo.consumer.servicePro.TestDubbo-demoService";
//		String[] aas = aa.split("-");
//		
//		Class obj;
//		try {
//			obj = Class.forName(aas[0]);
//			Field field1 = obj.getDeclaredField(aas[1]);
//			if (field1.isAccessible()) {
//				field1.set(SpringContextUtils.getBean(obj), s);
//			} else {
//				field1.setAccessible(true);
//				field1.set(SpringContextUtils.getBean(obj), s);
//				field1.setAccessible(false);
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchFieldException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		sl.add(s);
//		// 和本地bean一样使用xxxService
//		System.out.println(reference.get()); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
	}
}
