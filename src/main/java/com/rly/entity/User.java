package com.rly.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@auther ykw
 *@date 2020/12/14 17:23
 */
@Table
@Entity(name="user")
@Data
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
}
