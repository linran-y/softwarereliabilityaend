package com.rly.service;

import com.rly.Util.DataUtil;
import com.rly.dao.Datadao;
import com.rly.entity.Algorithmdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *@auther ykw
 *@date 2020/12/16 17:02
 */
@Transactional
@Service
public class Dataservice
{
    @Autowired
    private Datadao datadao;
    public Algorithmdata findbyId(int id)
    {
        Algorithmdata byId = datadao.findById(id);
        return byId;
    }
    public Algorithmdata findByName(String name)
    {
        return datadao.findByName(name);
    }
    public Algorithmdata adddata(String name,String in)
    {
        List<Double> doubles = DataUtil.StringtoDouble(in);
        return savedata(name,doubles);
    }

    public Algorithmdata updatedata(Integer id,String name, String in)
    {
        Algorithmdata byId = datadao.findById(id).get();
        byId.setData(DataUtil.StringtoDouble(in));
        byId.setName(name);
        return datadao.save(byId);
    }
    public Algorithmdata updatedata(String name, String data)
    {
        Algorithmdata byName = datadao.findByName(name);
        byName.setData(DataUtil.StringtoDouble(data));
        return datadao.save(byName);
    }
    public Algorithmdata savedata(String name,List<Double> data)
    {
        Algorithmdata algorithmdata=new Algorithmdata();
        algorithmdata.setData(data);
        algorithmdata.setName(name);
        return datadao.save(algorithmdata);
    }
    public List<Algorithmdata> queryall()
    {
        List<Algorithmdata> all = datadao.findAll();
        return all;
    }
    public void deleteByName(String name)
    {
        datadao.deleteByName(name);
    }

}
