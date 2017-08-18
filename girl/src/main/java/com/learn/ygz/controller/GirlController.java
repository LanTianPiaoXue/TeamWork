package com.learn.ygz.controller;

import com.learn.ygz.entity.Girl;
import com.learn.ygz.exception.ResponseHandler;
import com.learn.ygz.services.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("getGirls/")
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
   private GirlService girlService;

    public GirlService getGirlService() {
        return girlService;
    }

    public void setGirlService(GirlService girlService) {
        this.girlService = girlService;
    }

    // @RequestMapping(value = "/girls",method = RequestMethod.GET)
    @GetMapping("/girls")
    public Integer getGirlInfo2(@RequestParam(value = "id", required = false,defaultValue = "5") Integer myId){
        return myId;
    }

    /**
     * delete
     * @return
     */
   /* @DeleteMapping("/girl")
    public Integer deleteGirl(Girl girl){
        girl.setAge(girl.getAge());
        System.out.println("girl:"+girl);
        return  girlService.deleteGirl(girl);
    }*/
    @DeleteMapping("/girl/{id}")
    public Integer deleteGirlById(@PathVariable Integer id){
        return  girlService.deleteGirlById(id);
    }
    @PostMapping("/girl")
    public Integer insertGirl(@RequestParam(value = "name",required = false) String name,@RequestParam(value = "age",required = false) Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setName(name);
        return  girlService.insertGirl(girl);
    }

    @PutMapping("/girl/{id}")
    public Integer updateGirl(@PathVariable Integer id,@RequestParam("name") String name,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setName(name);
        return  girlService.updateGirl(girl);
    }

    @GetMapping("/girl/{id}")
    public Girl getGirl(@PathVariable Integer id){
       Girl girl = girlService.getGirl(id);
        return girl;
    }
    @GetMapping("/girl/all")
    public List<Girl> getGirls(){
        return girlService.getGirls();
    }

    @PostMapping("/girl/{id}")
    public Integer insertValidatedGirl(@Valid Girl girl, BindingResult bindingResult){
        logger.info("girl:"+girl);
        System.out.println("begin insertValidatedGirl");
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        return girlService.insertGirl(girl);
    }

    @PostMapping("/girl/getResponseHandler")
    public ResponseHandler getResponseHandler(@Valid Girl girl, BindingResult bindingResult){
        ResponseHandler<Girl> responseHandler = new ResponseHandler<Girl>();

        if(bindingResult.hasErrors()){
            responseHandler.setErrorCode(100);
            responseHandler.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return responseHandler;
        }
        System.out.println("test github!");
        Girl girl1 = girlService.insertGirl1(girl);
        responseHandler.setData(girl1);
        responseHandler.setErrorCode(0);
        responseHandler.setMessage("success");
        return responseHandler;
    }
}
