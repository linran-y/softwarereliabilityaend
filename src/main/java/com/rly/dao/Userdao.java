package com.rly.dao;

import com.rly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 *@auther ykw
 *@date 2020/12/14 17:27
 */
public interface Userdao extends JpaRepository<User,Integer>
{
    User findUserByNameAndPassword(String name,String password);
}
