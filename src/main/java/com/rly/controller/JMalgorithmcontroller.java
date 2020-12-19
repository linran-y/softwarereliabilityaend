package com.rly.controller;

import com.rly.algorithm.JM.JMalgorithmservice;
import com.rly.algorithm.JM.JMdata;
import com.rly.service.Dataservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/18 12:57
 */
@RestController
@RequestMapping("/JM")
public class JMalgorithmcontroller
{
    @Autowired
    JMalgorithmservice jMalgorithmservice;
    @Autowired
    Dataservice dataservice;
    @RequestMapping("/{name}/{ex}/{ey}")
    JMdata getJM_U(@PathVariable("name")String name, @PathVariable("ex")Double ex, @PathVariable("ey")Double ey)
    {
        List<Double> mytimedata=dataservice.findByName(name).getData();
        JMdata jMdata=new JMdata(mytimedata,ex,ey);
        return jMdata;
    }
}
