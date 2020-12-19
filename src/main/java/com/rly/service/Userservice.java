package com.rly.service;

import com.rly.dao.Userdao;
import com.rly.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/14 17:28
 */
@RestController
public class Userservice
{
    @Autowired
    private Userdao userdao;
    public void testfind(int id)
    {
        User user = userdao.findById(id).get();
        System.out.println(user);
    }
    public User findUserbynameandpassword(String name, String password)
    {
        User fuser = userdao.findUserByNameAndPassword(name, password);
        return fuser;
    }
}
