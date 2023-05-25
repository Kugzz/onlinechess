package com.apinanpaska.web.onlinechess.chessgame.chess;

import com.apinanpaska.web.util.chessgameutil.ChessUtil;

import java.util.ArrayList;
import java.util.List;

public class Chess {
    List<Piece> pieces;

    public Chess(){

        pieces = ChessUtil.createPieces();
    }

    public void startGame(){

    }
}
