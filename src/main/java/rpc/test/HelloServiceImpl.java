package rpc.test;

/**
 * Created by eagle on 2016/10/27.
 */
public class HelloServiceImpl implements HelloService{

    public String hello(String name){
        return "hello " + name;
    }
}
