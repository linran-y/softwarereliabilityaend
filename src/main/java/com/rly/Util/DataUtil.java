package com.rly.Util;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 *@auther ykw
 *@date 2020/12/17 10:13
 */
public class DataUtil
{
    static public ArrayList<Double> getrandomlist(int size)//返回一个size大小的随机list
    {
        ArrayList<Double>list=new ArrayList<Double>();
        for(int i=0;i<size;i++)
        {
            double x= new Random().nextDouble();
            list.add(x*10);
        }
        return list;
    }
    static public List<Double>StringtoDouble(String in)//输入一个由逗号隔开的字符串，转为double数组
    {

        List<String> terms = Arrays.asList(StringUtils.split(in, ","));
        List<Double> ansdouble = new ArrayList<Double>();
        for (String term : terms)
        {
            double v = Double.parseDouble(term);
            ansdouble.add(v);
        }
        return ansdouble;
    }

}
