package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String coupSize;
    private int age;
    private String name;

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

    @Override
    public String toString() {
        return age+" "+name+" "+coupSize;
    }
}
