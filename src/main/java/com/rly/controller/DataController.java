package com.rly.controller;

import com.rly.entity.Algorithmdata;
import com.rly.service.Dataservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/15 13:27
 * 主要负责和前端进行数据交互
 */
@RestController
@RequestMapping("/data")
public class DataController
{
    @Autowired
    Dataservice dataservice;

    @RequestMapping("query/{name}")
    List<Double>querydatabyname(@PathVariable("name")String name)
    {
        Algorithmdata byName = dataservice.findByName(name);
        return byName.getData();
    }
    @RequestMapping("query/all")
    List<Algorithmdata>queryall()
    {
        return dataservice.queryall();
    }
    @PostMapping("delete/{name}")
    void deleteByName(@PathVariable("name")String name)
    {
        dataservice.deleteByName(name);
    }
    @PostMapping("save/{id}/{name}/{datain}")
    Algorithmdata savedata(@PathVariable("id")Integer id,@PathVariable("name")String name,@PathVariable("datain")String datain)
    {
        if(id==-1)//新增数据
        {
            return dataservice.adddata(name,datain);
        }
        else
        {
            return dataservice.updatedata(id,name,datain);
        }
    }

}
