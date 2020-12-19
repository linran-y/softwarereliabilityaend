package com.rly.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/16 10:05
 */
@Entity(name="t_Algorithmdata")
@Table
@Data
public class Algorithmdata
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @ElementCollection(fetch=FetchType.EAGER)//关闭懒加载，不然取不到数据
    private List<Double>data = new ArrayList<Double>();

}
