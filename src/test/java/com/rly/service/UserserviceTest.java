package com.rly.service;

import com.rly.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserserviceTest
{
    @Autowired
    private Userservice userservice;
    @Test
    void queryone()
    {
        userservice.testfind(2);
    }
    @Test
    public void findUserByNameandpasswordtest()
    {
        User user = userservice.findUserbynameandpassword("ykw", "123456");
        System.out.println(user);
    }
}