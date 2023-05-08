package com.apinanpaska.web.htmlcontroller;

import com.apinanpaska.web.util.ControllerUtil;
import com.apinanpaska.web.util.GeneralUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @GetMapping("/rest/getToken")
    public String getToken(){
        return GeneralUtil.randomToken();
    }
}
