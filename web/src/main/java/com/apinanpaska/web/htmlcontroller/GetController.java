package com.apinanpaska.web.htmlcontroller;

import com.apinanpaska.web.util.GeneralUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/rest")
public class GetController {

    //toimi ainaki ku oli pelkkä ("getToken")
    @GetMapping("/getToken")
    public String getToken(){
        return GeneralUtil.randomToken();
    }

    //redirect toimii myös!
    @GetMapping("/apina")
    public ModelAndView redirectTest (){

        return new ModelAndView("redirect:http://localhost:8080/kissa");
    }
}
