package com.rly.algorithm.GO;

import com.rly.service.Dataservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GOalgorithmServiceTest
{
	@Autowired
	Dataservice dataservice;
	@Test
	void test1()
	{
		List<Double> mytimedata=dataservice.findByName("测试数据2").getData();
		GOdata godata=new GOdata(mytimedata,0.1);
		System.out.println(godata.getF());
		System.out.println(godata.getFun());
		System.out.println(godata.getR());
		System.out.println(godata.getMTTF());
	}
}