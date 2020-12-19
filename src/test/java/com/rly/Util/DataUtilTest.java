package com.rly.Util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataUtilTest
{
    @Test
    void test1()//测试字符串转Double数组
    {
        List<Double> doubles = DataUtil.StringtoDouble("1.2231,2.123,3.22,4.154,0.156");
        for (Double aDouble : doubles)
        {
            System.out.println(aDouble);
        }
    }
}