package com.rly.controller;

import com.rly.algorithm.GO.GOalgorithmService;


import com.rly.algorithm.GO.GOdata;
import com.rly.service.Dataservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/19 21:10
 */
@RestController
@RequestMapping("/GO")
public class GOalgorithmcontroller
{
    @Autowired
    GOalgorithmService gOalgorithmService;
    @Autowired
    Dataservice dataservice;
    @RequestMapping("/{name}/{zeta}")
    GOdata getJM_U(@PathVariable("name")String name, @PathVariable("zeta")Double zeta)
    {
        List<Double> mytimedata=dataservice.findByName(name).getData();
        GOdata godata=new GOdata(mytimedata,zeta);
        return godata;
    }
}
