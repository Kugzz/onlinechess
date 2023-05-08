package com.apinanpaska.web.util;

import java.util.ArrayList;

//contains all the boilerplate functions
public class ChessGameUtil {

    //checks if a player with a specific id is joined
    public static boolean playerJoined(String playerID, ArrayList<String> players){
        for(String player : players) if(playerID == player) return true;
        return false;
    }
}
