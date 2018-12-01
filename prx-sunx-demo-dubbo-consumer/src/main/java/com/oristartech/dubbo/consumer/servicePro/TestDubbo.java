package com.oristartech.dubbo.consumer.servicePro;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import prx.sunx.dubbo.serviceApi.DemoService;

/**
 * <p>
 * Created by sunx on 2017/9/20.
 * Description:
 */
@Service
public class TestDubbo {

	@Reference(retries=2)
//	@Qualifier("demoService")
//	@Autowired
	private DemoService demoService;

    public String testDubbo(String Str){
        try {
        	System.out.println("testDubbo");
			return this.demoService.sayHello(Str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
