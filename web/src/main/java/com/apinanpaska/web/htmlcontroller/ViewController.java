package com.apinanpaska.web.htmlcontroller;

import com.apinanpaska.web.onlinechess.OnlineChess;
import org.springframework.ui.Model;
import com.apinanpaska.web.db.dbmodels.GameMenuRenderModel;
import com.apinanpaska.web.util.GeneralUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ViewController {

    @GetMapping("/")
    public String mainmenu(Model model){

        //testi funktio (constructGames). Lisää oikea funktio chessagameen.
        //toimii!!!
        //model.addAttribute("games", costructGames());

        model.addAttribute("games", OnlineChess.renderGames());

        return "mainmenu";
    }

    @GetMapping("/view/game/{id}")
    public String game(@PathVariable("id") String roomID, Model model){
        System.out.println(roomID);

        return "test/game";
    }

    //test functions

    @GetMapping("/view/test")
    public String test(){
        return "test/test";
    }

    //voi varmaa jo poistaa
    private List<GameMenuRenderModel> costructGames(){
        List<GameMenuRenderModel> list = List.of(
                new GameMenuRenderModel(GeneralUtil.randomToken(), GeneralUtil.randomToken()),
                new GameMenuRenderModel(GeneralUtil.randomToken(), GeneralUtil.randomToken()),
                new GameMenuRenderModel(GeneralUtil.randomToken(), GeneralUtil.randomToken()));
        return list;
    }
}
