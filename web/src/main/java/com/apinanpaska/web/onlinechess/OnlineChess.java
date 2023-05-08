package com.apinanpaska.web.onlinechess;

import com.apinanpaska.web.onlinechess.chessgame.ChessGame;

import java.util.HashMap;
import java.util.Map;

public class OnlineChess {

    static int gameCount, maxGameCount;
    static Map games;

    private static void mainLoop(){
        //kutsu joitakin funktioita
        try{
            Thread.sleep(1000/60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mainLoop();
    }

    public static void run(){
        games = new HashMap<String, ChessGame>();
        gameCount = 0;
        maxGameCount = 0;
        //mainLoop();
    }

    //muuut funktiot

    public static String createGame(String clientID){
        String roomID = null;

        return roomID;
    }

    public static int connectClient(String clientID, String roomID){

        return 0;
    }

    public static int disconnectClient(String clientID, String roomID){

        return 0;
    }
}
