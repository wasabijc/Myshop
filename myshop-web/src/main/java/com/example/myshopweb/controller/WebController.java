package com.example.myshopweb.controller;
import com.example.myshopuser.controller.UserController;
import com.example.myshopweb.client.UserWebController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.myshopuser.pojo.User;


import javax.annotation.Resource;
import java.util.List;

/*** 购票Controller */
@RequestMapping("/web")
@RestController
@Api(description = "购票web核心Api")
public class WebController {
//      @Autowired
//      private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @Autowired
//    private LoadBalancerClient client;
    @Qualifier("com.example.myshopweb.client.UserWebController")
    @Autowired
    private UserWebController userWebController;
//    @Autowired
//    private RestTemplate restTemplate;
    /* * * 购票方法     */
    private static final Log log= LogFactory.getLog(WebController.class);
    @ApiOperation(value = "远程方法：根据ID查询用户的方法")
    @RequestMapping(value = "/order",method = RequestMethod.GET)
    //@HystrixCommand(fallbackMethod = "fallback")
    public String order(){
        log.info("开始调用order方法");
        //模拟当前用户
        Integer id = 2;
//        User user =restTemplate.getForObject("http://service-user/user/"+id, User.class);
        //远程调用用户微服务findbyid方法，第四步补充
        User user = userWebController.findById(id);
        System.out.println(user+"==正在购票...");
        return "购票成功";
    }
    //public String fallback(){return "服务暂时不可以，发生熔断。。。。。。。";}
}
