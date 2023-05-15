package com.apinanpaska.web.onlinechess.chessgame;

import com.apinanpaska.web.util.ChessGameUtil;

import java.util.ArrayList;

public class ChessGame {

    //muuttujia oikeasti enemmän
    int playerCount = 0; int maxPlayerCount = 2;
    String hostID;
    ArrayList<String> players = new ArrayList<String>();

    public ChessGame(String hostID){
        this.hostID = hostID;
    }

    //private functions

    //public functions

    public void iteration(){

    }

    //add player with value playerID
    public int addPlayer(String clientID){
        if(playerCount >= maxPlayerCount) return 1;
        if(ChessGameUtil.playerJoined(clientID, players)) return 2;

        players.add(clientID);

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

    public String getHostID() {
        return hostID;
    }
}
