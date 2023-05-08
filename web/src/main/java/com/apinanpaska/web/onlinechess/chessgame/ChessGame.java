package com.apinanpaska.web.onlinechess.chessgame;

import com.apinanpaska.web.util.ChessGameUtil;

import java.util.ArrayList;

public class ChessGame {

    //muuttujia oikeasti enemmän
    int playerCount, maxPlayerCount;
    ArrayList<String> players;

    public ChessGame(){
        playerCount = 0;
        maxPlayerCount = 0;
        players = new ArrayList<String>();
    }

    //add player with value playerID
    public int addPlayer(String clientID){
        if(playerCount >= maxPlayerCount) return 1;
        if(ChessGameUtil.playerJoined(clientID, players)) return 2;
        return 0;
    }

    //remove player with value playerID
    public int removePlayer(String clientID){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i) == clientID){
                players.remove(i);
                return 0;
            }
        }

        return 1;
    }

    //getters
    public int getPlayerCount() {
        return playerCount;
    }

    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }
}
