package com.rly.algorithm.SCH;

import com.rly.algorithm.GO.GOdata;
import com.rly.service.Dataservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SCHalgorithmServiceTest
{
	@Autowired
	Dataservice dataservice;
	@Test
	void test1()
	{
		List<Double> mytimedata=dataservice.findByName("测试数据3").getData();
		SCHdata godata=new SCHdata(mytimedata,0.1,0.1);
		System.out.println(godata.getF());
		System.out.println(godata.getFun());
		System.out.println(godata.getR());
		System.out.println(godata.getMTTF());
	}
}