package com.apinanpaska.web.htmlcontroller;

import com.apinanpaska.web.htmlcontroller.models.ConnectionModel;
import com.apinanpaska.web.onlinechess.OnlineChess;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping("/rest/createGame")
    public void createGame(@RequestBody ConnectionModel connectionModel){
        OnlineChess.createGame(connectionModel.clientID());
    }

    @PostMapping("/rest/connectClient")
    public void connectClient(@RequestBody ConnectionModel connectionModel){
        OnlineChess.connectClient(connectionModel.clientID(), connectionModel.roomID());
    }

}
