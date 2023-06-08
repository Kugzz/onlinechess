package com.apinanpaska.web.onlinechess.chessgame;

import com.apinanpaska.web.onlinechess.chessgame.chess.Chess;
import com.apinanpaska.web.util.chessgameutil.ChessGameUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//kontrolloi Chessin metodien kanssa
public class ChessGame {

    //muuttujia oikeasti enemmän
    int playerCount = 0; int maxPlayerCount = 2;
    String hostID;
    List<String> players = new ArrayList<String>();
    //Map<String, String> websockets = new HashMap<String, String>();

    //väliaikainen
    Chess chess = new Chess();

    public ChessGame(String hostID){
        this.hostID = hostID;
    }

    //private functions

    //public functions

    //hyödynnä lähinnä kellon kanssa
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

    /*
    public int mapWebsocket(String userID, String websocket){
        if(websockets.get(userID) != null) return 1;
        websockets.put(userID, websocket);

        return 0;
    }

    public int removeWebsocket(String userID){
        if(websockets.get(userID) == null) return 1;
        websockets.remove(userID);

        return 0;
    }
     */

    //getters
    public int getPlayerCount() {
        return playerCount;
    }

    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    public List<String> getPlayers() {
        return players;
    }

    public String getHostID() {
        return hostID;
    }
}
