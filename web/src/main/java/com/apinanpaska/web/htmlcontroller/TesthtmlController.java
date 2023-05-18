package com.apinanpaska.web.htmlcontroller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesthtmlController {

    //toimii!!!!
    //voi tyylii jo poistaa
    @GetMapping("/koira")
    public String koira(){
        System.out.println("koira");

        return "test";
    }

    @GetMapping("/kissa")
    public String kissa(){
        System.out.println("kissa");

        return "apina";
    }

}
