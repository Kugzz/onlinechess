package com.apinanpaska.web.onlinechess.chessgame.websockets;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    //tests

    @MessageMapping("/sendToUser/{userID}")
    public void sendToUser(@DestinationVariable("userID") String userID, String message){
        System.out.println(userID);
        System.out.println("message " + message);
        simpMessagingTemplate.convertAndSendToUser(userID, "/queue/reply", "hello!");
    }

    public void sendDataToUser(String userID){
        simpMessagingTemplate.convertAndSendToUser(userID, "/queue/reply", "hello!");
    }

    //ois varmaa hyvä, jos pystyis lähettää kuvaa vaa huoneesee, jolloin kaikki siel olivat näkis
}
