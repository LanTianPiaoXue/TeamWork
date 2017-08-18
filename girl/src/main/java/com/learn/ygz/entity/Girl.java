package com.learn.ygz.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
public class Girl implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @Min(value = 18,message = "未成年人禁止入内！")
    private String coupSize;
    private int age;
    private String name;

    public Girl() {

    }

    public String getCoupSize() {
        return coupSize;
    }

    public void setCoupSize(String coupSize) {
        this.coupSize = coupSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return age+" "+name+" "+coupSize;
    }
}
