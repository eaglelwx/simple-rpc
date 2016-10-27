package rpc.test;

import rpc.framework.RpcFramework;

/**
 * Created by eagle on 2016/10/27.
 */
public class RpcProvider {

    public static void main(String[] args)throws Exception{
        HelloService helloService = new HelloServiceImpl();
        RpcFramework.export(helloService, 8000);
    }
}
