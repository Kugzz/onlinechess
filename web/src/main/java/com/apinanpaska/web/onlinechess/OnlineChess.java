package com.apinanpaska.web.onlinechess;

import com.apinanpaska.web.onlinechess.chessgame.ChessGame;
import com.apinanpaska.web.util.ChessGameUtil;
import com.apinanpaska.web.util.GeneralUtil;

import java.util.*;

public class OnlineChess {

    //tähän
    static final int maxGameCount = 20;
    static int gameCount = 0;
    static Map<String, ChessGame> games;

    //create settings model if required
    public static String createGame(String clientID){
        if(gameCount >= maxGameCount) return null;

        String roomID = GeneralUtil.randomToken();
        games.put(roomID, new ChessGame());
        gameCount++;

        return roomID;
    }

    //connects client to specified game
    public static int connectClient(String clientID, String roomID){

        return games.get(roomID).addPlayer(clientID);
    }

    //disconnect client from game
    public static int disconnectClient(String clientID, String roomID){
        if(!ChessGameUtil.playerJoined(clientID, games.get(roomID).getPlayers())) return 1; //järjestä error koodit uudelleen

        return games.get(roomID).removePlayer(clientID);
    }

    //main and run

    private static void mainLoop(){

        for(ChessGame game : games.values()) game.iteration();

        try{
            Thread.sleep(1000/60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mainLoop();
    }

    public static void run(){
        games = new HashMap<String, ChessGame>();
        //mainLoop();
    }
}
