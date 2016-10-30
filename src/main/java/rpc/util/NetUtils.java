package rpc.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * Created by eagle on 2016/10/30.
 */
public class NetUtils {

    private static final String LOCAL_HOST = "127.0.0.1";
    private static final String ANY_HOST = "0.0.0.0";
    public static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3}$");


    public static String getHostAddressFromInterface(){

        try{

            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while(interfaces.hasMoreElements()){

                NetworkInterface network  = interfaces.nextElement();
                Enumeration<InetAddress> addresses = network.getInetAddresses();
                while(addresses.hasMoreElements()){
                    InetAddress inetAddress = addresses.nextElement();
                    if(!inetAddress.isLoopbackAddress() && isValidHostAddress(inetAddress.getHostAddress())){
                        return inetAddress.getHostAddress();
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static boolean isValidHostAddress(String hostAddress){

        boolean is =  IP_PATTERN.matcher(hostAddress).matches();

        return (null != hostAddress) && !LOCAL_HOST.equals(hostAddress)
                && !ANY_HOST.equals(hostAddress) && is;
    }

}