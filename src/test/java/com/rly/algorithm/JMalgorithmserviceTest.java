package com.rly.algorithm;

import com.rly.Util.DataUtil;
import com.rly.algorithm.JM.JMalgorithmservice;
import com.rly.algorithm.JM.JMdata;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class JMalgorithmserviceTest
{


    @Test
    public void test1()
    {
        List<Double> in= DataUtil.getrandomlist(10);
        JMdata jMdata=new JMdata(in,0.1,0.1);
        System.out.println(jMdata.getF());
        System.out.println(jMdata.getFun());
        System.out.println(jMdata.getR());
        System.out.println(jMdata.getMTTF());
    }
}
