package com.rly.controller;

import com.rly.algorithm.GO.GOalgorithmService;
import com.rly.algorithm.GO.GOdata;
import com.rly.algorithm.SCH.SCHalgorithmService;
import com.rly.algorithm.SCH.SCHdata;
import com.rly.service.Dataservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/19 22:34
 */
@RestController
@RequestMapping("/SCH")
public class SCHalgorithmcontroller
{
	@Autowired
	SCHalgorithmService scHalgorithmService;
	@Autowired
	Dataservice dataservice;
	@RequestMapping("/{name}/{ux}/{uy}")
	SCHdata getJM_U(@PathVariable("name")String name, @PathVariable("ux")Double ux, @PathVariable("uy")Double uy)
	{
		List<Double> mytimedata=dataservice.findByName(name).getData();
		SCHdata schdata=new SCHdata(mytimedata,ux,uy);
		return schdata;
	}
}
