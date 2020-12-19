package com.rly.service;

import com.rly.Util.DataUtil;
import com.rly.entity.Algorithmdata;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DataserviceTest
{
    @Autowired
    private Dataservice dataservice;

    @Test
    void test1()//测试数据是否成功存入数据库
    {
        for(int i=5;i<=20;i++)
        {
            ArrayList<Double> getrandomlist = DataUtil.getrandomlist(5);
            dataservice.savedata("测试数据"+i,getrandomlist);
        }

    }
    @Test
    void test2()//测试数据是否可以从数据库取出,这里需要解决懒加载问题
    {
        Algorithmdata nametest = dataservice.findByName("测试数据1");
        System.out.println(nametest);
    }
    @Test
    void test3()//测试覆盖修改效果
    {
        //ArrayList<Double> getrandomlist = DataUtil.getrandomlist(2);
        dataservice.updatedata("测试数据1","1,2,3,4,5,6");

    }
    @Test
    void test4()//测试findall
    {
        List<Algorithmdata> queryall = dataservice.queryall();
        for (Algorithmdata algorithmdata : queryall)
        {
            System.out.println(algorithmdata);
        }
    }
    @Test
    void test5()//测试删除功能
    {
        dataservice.deleteByName("测试数据2");
    }

    @Test
    void test6()//测试字符串新增方法
    {
        Algorithmdata adddata = dataservice.adddata("测试数据12", "1.2,1.3,1.4,50,100");
        System.out.println(adddata);
    }

}