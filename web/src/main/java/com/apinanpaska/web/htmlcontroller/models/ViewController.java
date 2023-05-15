package com.apinanpaska.web.htmlcontroller.models;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    @GetMapping("/")
    public String mainmenu(Model model){
        //lisäää atributet
        return "mainmenu";
    }

    @GetMapping("/view/game/{id}")
    public String game(@PathVariable("id") String roomID, Model model){
        System.out.println(roomID);

        return "test/game";
    }

    //testejä varten
    @GetMapping("/view/test")
    public String test(){
        return "test/test";
    }
}
