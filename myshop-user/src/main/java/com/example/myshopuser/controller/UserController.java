package com.example.myshopuser.controller;

import com.example.myshopuser.pojo.User;

import com.example.myshopuser.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

/*** 用户Controller */
@RequestMapping("/user")
@RestController   // @RestController=@RequestMapping + @ResponseBody
//@Api(description = "用户控制器")
public class UserController {
    @Autowired
    private UserService userService;
    /*** 查询所有用户     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "查询所有用户")
    public List<User> findAll(){
        return userService.findAll();
    }
    /*** 根据id查询用户     */
    private static final Log log= LogFactory.getLog(UserController.class);
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "查询主键用户")
    public User findById(@PathVariable Integer id){
        log.info("进入了UserController的findById方法");
        System.out.println("用户微服务11111");
        return userService.findById(id);    }
    /*** 添加用户     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "添加用户")
    public String add(@RequestBody User user){
        userService.add(user);
        return "添加成功";    }
    /*** 修改用户     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户")
    public String update(@RequestBody User user,@PathVariable Integer id){
        //设置id
        user.setId(id);
        userService.update(user);
        return "修改成功";    }
    /*** 根据id删除用户     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户")
    public String deleteById(@PathVariable Integer id){
        userService.deleteById(id);
        return "删除成功";    }
}

