package com.apinanpaska.web.htmlcontroller;

import com.apinanpaska.web.htmlcontroller.models.ConnectionClientModel;
import com.apinanpaska.web.onlinechess.OnlineChess;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping("/rest/createGame")
    public void createGame(@RequestBody ConnectionClientModel connectionClientModel){
        OnlineChess.createGame(connectionClientModel.clientID());
    }

    @PostMapping("/rest/connectClient")
    public void connectClient(@RequestBody ConnectionClientModel connectionClientModel){
        OnlineChess.connectClient(connectionClientModel.clientID(), connectionClientModel.roomID());
    }

}
