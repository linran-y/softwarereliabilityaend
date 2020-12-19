package com.rly.dao;

import com.rly.entity.Algorithmdata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/16 17:45
 */
public interface Datadao extends JpaRepository<Algorithmdata,Integer>
{
    Algorithmdata findById(int id);
    Algorithmdata findByName(String name);
    void deleteByName(String name);
}
