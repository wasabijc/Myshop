package com.example.myshopweb.client;

import com.example.myshopuser.controller.UserController;
import com.example.myshopuser.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements UserWebController {
    @Override
    public User findById(Integer id){
        System.out.println("执行了熔断器类...");
        return null;
    }
}
