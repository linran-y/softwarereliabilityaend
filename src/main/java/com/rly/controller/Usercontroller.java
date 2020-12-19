package com.rly.controller;

import com.rly.entity.User;
import com.rly.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@auther ykw
 *@date 2020/12/14 18:15
 */
@RestController
@RequestMapping("/user")
public class Usercontroller
{
    @Autowired
    Userservice userservice;

    @RequestMapping("/finduser/{name}/{password}")
    User findUser(@PathVariable("name") String name,@PathVariable("password") String password)
    {
        return userservice.findUserbynameandpassword(name,password);
    }
}
