package com.apinanpaska.web.onlinechess.chessgame;

import com.apinanpaska.web.util.ChessGameUtil;

import java.util.ArrayList;

public class ChessGame {

    //muuttujia oikeasti enemmän
    int playerCount, maxPlayerCount;
    ArrayList<String> players;

    ChessGame(){
        playerCount = 0;
        maxPlayerCount = 0;
        players = new ArrayList<String>();
    }

    //add player with value playerID
    public int addPlayer(String playerID){
        if(playerCount >= maxPlayerCount) return 1;
        if(ChessGameUtil.playerJoined(playerID, players)) return 2;
        return 0;
    }

    //remove player with value playerID
    public int removePlayer(String playerID){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i) == playerID){
                players.remove(i);
                return 0;
            }
        }

        return 1;
    }
}
