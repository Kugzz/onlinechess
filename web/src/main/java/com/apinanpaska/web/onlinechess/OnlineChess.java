package com.apinanpaska.web.onlinechess;

import com.apinanpaska.web.onlinechess.chessgame.ChessGame;
import com.apinanpaska.web.util.ChessGameUtil;
import com.apinanpaska.web.util.GeneralUtil;

import java.util.*;

public class OnlineChess {

    static final int maxGameCount = 20;
    static int gameCount;
    static Map<String, Integer> rooms;
    static ArrayList<ChessGame> games;

    //muuut funktiot
    //korjaa noi

    //create settings model if required
    public static String createGame(String clientID){
        if(gameCount >= maxGameCount) return null;
        int roomIndex = -1;
        for(int i = 0; i < maxGameCount; i++){
            if(games.get(i) == null) {
                roomIndex = i;
                break;
            }
        }
        if(roomIndex == -1) return null;

        String roomID = GeneralUtil.randomToken();
        games.set(roomIndex, new ChessGame());
        rooms.put(roomID, roomIndex);

        return roomID;
    }

    public static int connectClient(String clientID, String roomID){
        if (games.get(rooms.get(roomID)).getPlayerCount() >= games.get(rooms.get(roomID)).getMaxPlayerCount()) return 1;
        games.get(rooms.get(roomID)).addPlayer(clientID);

        return 0;
    }

    public static int disconnectClient(String clientID, String roomID){
        if(!ChessGameUtil.playerJoined(clientID, games.get(rooms.get(roomID)).getPlayers())) return 1; //järjestä error koodit uudelleen

        return games.get(rooms.get(roomID)).removePlayer(clientID);
    }

    //main and run

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
        gameCount = 0;
        rooms = new HashMap<String, Integer>();
        games = new ArrayList<ChessGame>(Collections.nCopies(maxGameCount, null));
        //mietin lista inittausta
        //mainLoop();
    }

    //Testaa funktioita
}
