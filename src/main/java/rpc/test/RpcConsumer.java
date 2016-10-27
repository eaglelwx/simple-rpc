package rpc.test;

import rpc.framework.RpcFramework;

/**
 * Created by eagle on 2016/10/27.
 */
public class RpcConsumer {

    public static void main(String[] args)throws Exception{
        HelloService helloService = RpcFramework.refer(HelloService.class, "127.0.0.1", 8000);
        System.out.println(helloService.hello("world"));
    }
}
