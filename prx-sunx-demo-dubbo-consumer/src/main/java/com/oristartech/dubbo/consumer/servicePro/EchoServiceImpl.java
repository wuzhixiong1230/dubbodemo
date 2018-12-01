package com.oristartech.dubbo.consumer.servicePro;



import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import prx.sunx.dubbo.serviceApi.EchoService;


/**
 * <p>
 * Created by sunx on 2017/9/19.
 * Description:
 */
@Service
public class EchoServiceImpl  implements EchoService{

	@Override
	public String echo(String str) {
		System.out.println("echo: " + str + " param: " + RpcContext.getContext().getArguments()[0]);
        return str+" echo ";
	}
}
