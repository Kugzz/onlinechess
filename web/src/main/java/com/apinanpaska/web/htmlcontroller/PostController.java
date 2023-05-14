package com.apinanpaska.web.htmlcontroller;

import com.apinanpaska.web.htmlcontroller.models.ConnectionClientModel;
import com.apinanpaska.web.htmlcontroller.models.ConnectionServerModel;
import com.apinanpaska.web.htmlcontroller.models.CreateGameResponseModel;
import com.apinanpaska.web.onlinechess.OnlineChess;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;

@RestController
public class PostController {


    @PostMapping("/rest/createGame")
    public ConnectionServerModel createGame(@RequestBody ConnectionClientModel connectionClientModel){
        System.out.println("createGame request made");
        return new ConnectionServerModel(null, null, OnlineChess.createGame(connectionClientModel.clientID()));
    }

    @PostMapping("/rest/connectClient")
    public ConnectionServerModel connectClient(@RequestBody ConnectionClientModel connectionClientModel){
        System.out.println("connectClient request made");
        return new ConnectionServerModel(OnlineChess.connectClient(connectionClientModel.clientID(), connectionClientModel.roomID()), null, null);
    }

}
