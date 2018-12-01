package prx.demo.dubbo.provider.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;

//import prx.demo.dubbo.provider.dao.CityDao;
import prx.demo.dubbo.provider.domain.City;
import prx.sunx.dubbo.serviceApi.DubboService;
import prx.sunx.dubbo.serviceApi.EchoService;

@Component
public class DubboServiceImpl implements DubboService {

	@Reference(check=false,retries=2)
	EchoService echoService;

	public EchoService getEchoService() {
		return echoService;
	}

	public void setEchoService(EchoService echoService) {
		this.echoService = echoService;
	}
	
//	@Autowired
//    private CityDao cityDao;

	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
	public String dubboEcho(String name)  throws Exception{
//		SpringContextUtils.getBean(DubboService.class).getEchoService().echo(name);
		try{
//			City c = cityDao.findByName(name);
//	    	c.setId(c.getId()+1);
//	    	c.setProvinceId(c.getProvinceId()+1);
//	    	List<City> citys = new ArrayList<City>();
//	    	citys.add(c);
//	    	cityDao.insertCity(citys);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
    	
    	return "OK";
//		String str = echoService.echo(name)+"sayHello-dubboEcho";
//    	System.out.println("dubboEcho: " + str + " param: " + RpcContext.getContext().getArguments()[0]);
//        return str;
	}
	
	
	
//	@Transactional(rollbackFor=Exception.class)
	public void transction2() throws Exception{
		try{
//			List<Long> ids = new ArrayList<Long>();
//	    	ids.add(5L);
//	    	cityDao.updateCity(ids);
//	//    	return SpringContextUtils.getBean(DubboService.class).dubboEcho(name);
//	    	City c1 = cityDao.findByName("22");
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
}
