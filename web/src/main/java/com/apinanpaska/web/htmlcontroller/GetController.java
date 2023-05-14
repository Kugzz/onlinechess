package com.apinanpaska.web.htmlcontroller;

import com.apinanpaska.web.util.ControllerUtil;
import com.apinanpaska.web.util.GeneralUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GetController {

    @GetMapping("/rest/getToken")
    public String getToken(){
        return GeneralUtil.randomToken();
    }

    //testi
    //jatka redirectien kanssa
    @GetMapping("rest/apina")
    public ModelAndView redirectTest (){
        //System.out.println("apina");
        return new ModelAndView("redirect:http://localhost:8080/apina.html");

        //HttpServletResponse httpServletResponse
        //httpServletResponse.setHeader("Location", "http://localhost:8080/apina.html");
        //httpServletResponse.setStatus(302);
    }
}
