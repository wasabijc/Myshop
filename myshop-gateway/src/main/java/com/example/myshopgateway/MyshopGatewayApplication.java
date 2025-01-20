package com.example.myshopgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableZuulProxy
@EnableSwagger2
public class MyshopGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshopGatewayApplication.class, args);
    }

}
