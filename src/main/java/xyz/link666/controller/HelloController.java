package xyz.link666.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @RequestMapping("hello")
    @ResponseBody
    public String  hello() {
        return "Hello mother fucker666888";
    }

    //@RequestMapping("/")
    //public String index(){
    //    return "/index";
    //}
}
