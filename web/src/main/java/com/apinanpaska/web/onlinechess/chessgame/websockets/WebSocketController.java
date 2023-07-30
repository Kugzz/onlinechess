package com.apinanpaska.web.onlinechess.chessgame.websockets;

import com.apinanpaska.web.onlinechess.OnlineChess;
import com.apinanpaska.web.onlinechess.chessgame.websockets.models.ClientState;
import com.apinanpaska.web.onlinechess.chessgame.websockets.models.GameState;
import com.apinanpaska.web.onlinechess.chessgame.websockets.models.PieceData;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private record ClientRoomIDs (String clientID, String roomID){}

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    //client-specific functions
    //called when a client first times loads the game
    @MessageMapping("/loadGameState")
    public void loadGameState(ClientRoomIDs clientRoomIDs){
        String roomID = clientRoomIDs.roomID();
        simpMessagingTemplate.convertAndSendToUser(clientRoomIDs.clientID, "/loadGameState", OnlineChess.getGames().get(roomID).getGameState());
    }

    //called when user requests data about available moves
    public void sendPieceData(PieceData pieceData){
        simpMessagingTemplate.convertAndSendToUser(pieceData.clientID(), "/pieceData", pieceData);
    }

    //room-specific functions
    //function for updating gamedata for all clients in the room
    public void sendGameState(GameState gameState, String roomID){
        System.out.println("sendGameState");
        simpMessagingTemplate.convertAndSend("/topic/gameState/" + roomID, OnlineChess.getGames().get(roomID).getGameState());
    }

    //päivitä servericlientin datalla (funktio)
    //testaa jossain kohtii
    @MessageMapping("/clientEvent")
    public void clientEvent(ClientState clientState){
        System.out.println("client event!!");

        //jos paskaa kerääntyy liian paljon voi tehä erillisen service classin logiikalle.
        //siin voi myös kokeilla spring beaneja
        if(clientState.eventType() == 1){
            PieceData pieceData = OnlineChess.getGames().get(clientState.roomID()).requestPieceData(clientState);
            sendPieceData(pieceData);
            return;
        }
        if(clientState.eventType() == 2){

        }
    }

    //testi
    @MessageMapping("/sendToUser/{userID}")
    public void sendToUser(@DestinationVariable("userID") String userID, String message){
        System.out.println(userID);
        System.out.println("message " + message);

        // user/userID + "/reply"
        simpMessagingTemplate.convertAndSendToUser(userID, "/reply", "hello!");
    }
}
