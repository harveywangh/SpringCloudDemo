package com.example.kaidun.consumer.ribbon;

//import com.netflix.client.ClientFactory;
//import com.netflix.client.http.HttpRequest;
//import com.netflix.client.http.HttpResponse;
//import com.netflix.config.ConfigurationManager;
//import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
//import com.netflix.niws.client.http.RestClient;
//
//import java.net.URI;

//ribbon 使用讲解
/*最好的情况是Ribbon和Eurake配合使用*/
public class test {
    public  static void main(String[] args) throws Exception {
        /*d读取配置文件*/
//        ConfigurationManager.loadPropertiesFromResources("dahang.properties");  // 1
//        System.err.println(ConfigurationManager.getConfigInstance().getProperty("sample-client.ribbon.listOfServers"));
//
//        /*1、构建http Client  基于serverLst固定的情况*/
//        RestClient client = (RestClient) ClientFactory.getNamedClient("dahang-client");  // 2
//        HttpRequest request = HttpRequest.newBuilder().uri(new URI("/")).build(); // 3
////            for (int i = 0; i < 5; i++)  {
////                HttpResponse response = client.executeWithLoadBalancer(request); // 4
////                System.err.println("Status code for " + response.getRequestedURI() + "  :" + response.getStatus());
////            }
//
//        /*开发周期之内，可以替换*/
//        /*动态修改的serverList*/
//        ZoneAwareLoadBalancer lb = (ZoneAwareLoadBalancer) client.getLoadBalancer();
//        System.err.println(lb.getLoadBalancerStats());
//        ConfigurationManager.getConfigInstance().setProperty(
//                "dahang-client.ribbon.listOfServers", "www.qq.com:80,www.taobao.com:80"); // 5
//        System.err.println("changing servers ...");
//        Thread.sleep(3000); // 6
//        for (int i = 0; i < 5; i++)  {
//            HttpResponse response = client.executeWithLoadBalancer(request);
//            System.err.println("Status code for " + response.getRequestedURI() + "  : " + response.getStatus());
//        }
//        System.out.println(lb.getLoadBalancerStats()); // 7



    }

}
