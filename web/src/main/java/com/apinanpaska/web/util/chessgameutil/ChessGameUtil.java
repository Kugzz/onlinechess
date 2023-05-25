package com.apinanpaska.web.util.chessgameutil;

import java.util.ArrayList;

//contains all the boilerplate functions
public class ChessGameUtil {

    //checks if a player with a specific id is joined
    public static boolean playerJoined(String playerID, ArrayList<String> players){
        for(String player : players) {
            player.trim();
            playerID.trim();
            if(playerID.equals(player)) return true;
        }
        return false;
    }

}
