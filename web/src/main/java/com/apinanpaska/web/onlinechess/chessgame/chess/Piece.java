package com.apinanpaska.web.onlinechess.chessgame.chess;

import com.apinanpaska.web.util.enums.Side;
import com.apinanpaska.web.util.enums.PieceType;
import com.apinanpaska.web.util.records.Coords;

public class Piece {

    int id;
    Side side;
    PieceType pieceType;
    Coords coords;
    boolean alive = true; boolean clicked = false;

    public Piece(int id, Side side, PieceType pieceType, Coords coords){
        this.id = id;
        this.side = side;
        this.pieceType = pieceType;
        this.coords = coords;
    }
}
