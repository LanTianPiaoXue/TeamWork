package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private GirlProperties girl;
    @Value("${coupsize}")
    private String coupSize;
    @RequestMapping(value = "/hello3",method = RequestMethod.GET)
    public  String say(){
        return "Hello World!";
    }
    @RequestMapping(value = "/coupSize",method = RequestMethod.GET)
    public  String getCoupSize(){
        return coupSize;
    }
    @RequestMapping(value = "getGirlInfo",method = RequestMethod.GET)
    public String getGirlInfo(){
        return girl.toString();
    }
}
