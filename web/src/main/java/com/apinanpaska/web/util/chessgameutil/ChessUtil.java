package com.apinanpaska.web.util.chessgameutil;

import java.util.ArrayList;
import java.util.List;

import com.apinanpaska.web.onlinechess.chessgame.chess.Piece;
import com.apinanpaska.web.util.enums.PieceType;
import com.apinanpaska.web.util.enums.Side;
import com.apinanpaska.web.util.records.Coords;

public class ChessUtil {

    public static List<Piece> createPieces(){
        List<Piece> pieceList = new ArrayList<Piece>();

        //white special
        pieceList.add(new Piece(1, Side.WHITE, PieceType.RK, new Coords(1, 1)));
        pieceList.add(new Piece(2, Side.WHITE, PieceType.HR, new Coords(2, 1)));
        pieceList.add(new Piece(3, Side.WHITE, PieceType.BH, new Coords(3, 1)));
        pieceList.add(new Piece(4, Side.WHITE, PieceType.QN, new Coords(4, 1)));
        pieceList.add(new Piece(5, Side.WHITE, PieceType.KG, new Coords(5, 1)));
        pieceList.add(new Piece(6, Side.WHITE, PieceType.BH, new Coords(6, 1)));
        pieceList.add(new Piece(7, Side.WHITE, PieceType.HR, new Coords(7, 1)));
        pieceList.add(new Piece(8, Side.WHITE, PieceType.RK, new Coords(8, 1)));

        //white pawns
        pieceList.add(new Piece(9, Side.WHITE, PieceType.PW, new Coords(1, 2)));
        pieceList.add(new Piece(10, Side.WHITE, PieceType.PW, new Coords(2, 2)));
        pieceList.add(new Piece(11, Side.WHITE, PieceType.PW, new Coords(3, 2)));
        pieceList.add(new Piece(12, Side.WHITE, PieceType.PW, new Coords(4, 2)));
        pieceList.add(new Piece(13, Side.WHITE, PieceType.PW, new Coords(5, 2)));
        pieceList.add(new Piece(14, Side.WHITE, PieceType.PW, new Coords(6, 2)));
        pieceList.add(new Piece(15, Side.WHITE, PieceType.PW, new Coords(7, 2)));
        pieceList.add(new Piece(16, Side.WHITE, PieceType.PW, new Coords(8, 2)));
        
        //black pawns
        pieceList.add(new Piece(17, Side.BLACK, PieceType.PW, new Coords(1, 7)));
        pieceList.add(new Piece(18, Side.BLACK, PieceType.PW, new Coords(2, 7)));
        pieceList.add(new Piece(19, Side.BLACK, PieceType.PW, new Coords(3, 7)));
        pieceList.add(new Piece(20, Side.BLACK, PieceType.PW, new Coords(4, 7)));
        pieceList.add(new Piece(21, Side.BLACK, PieceType.PW, new Coords(5, 7)));
        pieceList.add(new Piece(22, Side.BLACK, PieceType.PW, new Coords(6, 7)));
        pieceList.add(new Piece(23, Side.BLACK, PieceType.PW, new Coords(7, 7)));
        pieceList.add(new Piece(24, Side.BLACK, PieceType.PW, new Coords(8, 7)));
        
        //black special
        pieceList.add(new Piece(25, Side.BLACK, PieceType.RK, new Coords(1, 8)));
        pieceList.add(new Piece(26, Side.BLACK, PieceType.HR, new Coords(2, 8)));
        pieceList.add(new Piece(27, Side.BLACK, PieceType.BH, new Coords(3, 8)));
        pieceList.add(new Piece(28, Side.BLACK, PieceType.QN, new Coords(4, 8)));
        pieceList.add(new Piece(29, Side.BLACK, PieceType.KG, new Coords(5, 8)));
        pieceList.add(new Piece(30, Side.BLACK, PieceType.BH, new Coords(6, 8)));
        pieceList.add(new Piece(31, Side.BLACK, PieceType.HR, new Coords(7, 8)));
        pieceList.add(new Piece(32, Side.BLACK, PieceType.RK, new Coords(8, 8)));


        return pieceList;
    }
}
