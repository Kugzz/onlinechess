package com.apinanpaska.web.onlinechess.chessgame;

import com.apinanpaska.web.onlinechess.chessgame.chess.Chess;
import com.apinanpaska.web.onlinechess.chessgame.websockets.models.ClientState;
import com.apinanpaska.web.onlinechess.chessgame.websockets.models.GameState;
import com.apinanpaska.web.onlinechess.chessgame.websockets.models.PieceData;
import com.apinanpaska.web.util.chessgameutil.ChessGameUtil;

import java.util.ArrayList;
import java.util.List;

//kontrolloi Chessin metodien kanssa
public class ChessGame {

    //muuttujia oikeasti enemmän
    int playerCount = 0; int maxPlayerCount = 2;
    String hostID;
    List<String> players = new ArrayList<String>();
    Chess chess = new Chess();

    public ChessGame(String hostID){
        this.hostID = hostID;
    }

    public GameState getGameState(){
        return chess.getGameState();
    }

    public PieceData requestPieceData (ClientState clientState){
        return chess.requestPieceData(clientState);
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

    //hyödynnä lähinnä kellon kanssa
    public void iteration(){

    }

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
