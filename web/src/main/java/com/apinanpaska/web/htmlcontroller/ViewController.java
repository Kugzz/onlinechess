package com.apinanpaska.web.htmlcontroller;

import com.apinanpaska.web.onlinechess.OnlineChess;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

    @GetMapping("/")
    public String mainmenu(Model model){

        model.addAttribute("games", OnlineChess.renderGames());

        return "mainmenu";
    }

    @GetMapping("/game/{id}")
    public String game(@PathVariable("id") String roomID, Model model){

        return "game";
    }

}
