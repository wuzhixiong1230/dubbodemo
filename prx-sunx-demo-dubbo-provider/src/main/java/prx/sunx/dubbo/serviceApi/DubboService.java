package prx.sunx.dubbo.serviceApi;

public interface DubboService {

	public String dubboEcho(String name) throws Exception;
	
	public EchoService getEchoService();
	
	public void transction2() throws Exception;
}
