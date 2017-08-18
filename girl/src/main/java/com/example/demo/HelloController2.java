package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/boy")
public class HelloController2 {

   /* @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public  String say(){
        return "index";
    }*/
   @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public  String say(){
        return "index";
    }

}
