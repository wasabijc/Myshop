package com.example.myshopweb.client;

import com.example.myshopuser.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "myshop-user",fallback = UserControllerImpl.class)
public interface UserWebController {
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable(value = "id") Integer id);
}
