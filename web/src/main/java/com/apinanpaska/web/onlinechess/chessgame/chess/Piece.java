package com.apinanpaska.web.onlinechess.chessgame.chess;

import com.apinanpaska.web.util.chessgameutil.PieceUtil;
import com.apinanpaska.web.util.enums.Side;
import com.apinanpaska.web.util.enums.PieceType;
import com.apinanpaska.web.util.records.Coords;

import java.util.ArrayList;
import java.util.List;

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

    //moveset

    private boolean squareAvailable(Coords targetCoords, List<Piece> pieces){
        for(Piece piece : pieces){
            if(piece.getId() == id) continue;
            if(piece.getCoords().equals(targetCoords) && piece.isAlive()) return false;
        }
        if(targetCoords.x() < 1 || targetCoords.x() > 8) return false;
        if(targetCoords.y() < 1 || targetCoords.y() > 8) return false;

        return true;
    }

    int getPieceID(Coords targetCoords, List<Piece> pieces){
        for(Piece piece : pieces){
            if(piece.getId() == id) continue;
            if(piece.getCoords().equals(targetCoords) && piece.isAlive()) return piece.getId();
        }
        return -1;
    }

    //pawn only!
    private boolean canEat(Coords coords, List<Piece> pieces){
        if (!squareAvailable(coords, pieces)) return false;
        for(Piece piece : pieces){
            if(piece.getId() == id) continue;
            if(piece.getCoords().equals(coords) && piece.getSide() != side && piece.isAlive()) return true;
        }
        return false;
    }

    private boolean checkSide(Coords targetCoords, List<Piece> pieces){
        int pieceID = getPieceID(targetCoords, pieces);
        if(pieceID == -1) return false;
        return pieces.get(pieceID).getSide() == side;
    }

    private List<Coords> lineMoves (int deltaX, int deltaY, List<Piece> pieces){
        List<Coords> moves = new ArrayList<Coords>();

        for(int i = 1; i <= 8; i++){
            if(squareAvailable(new Coords(coords.x() + i * deltaX, coords.y() + i * deltaY), pieces))
                moves.add(new Coords(coords.x() + i * deltaX, coords.y() + i * deltaY));
            else {
                if(checkSide(new Coords(coords.x() + i * deltaX, coords.y() + i * deltaY), pieces))
                        moves.add(new Coords(coords.x() + i * deltaX, coords.y() + i * deltaY));
                break;
            }
        }

        return moves;
    }

    private List<Coords> straightMoves(List<Piece> pieces){
        List<Coords> moves = new ArrayList<Coords>();

        //up, right, down, left
        moves.addAll(lineMoves(0, 1, pieces));
        moves.addAll(lineMoves(1, 0, pieces));
        moves.addAll(lineMoves(0, -1, pieces));
        moves.addAll(lineMoves(-1, 0, pieces));

        return moves;
    }

    private List<Coords> diagonalMoves(List<Piece> pieces){
        List<Coords> moves = new ArrayList<Coords>();

        //up-right, down-right, down-left, up-left
        moves.addAll(lineMoves(1, 1, pieces));
        moves.addAll(lineMoves(1, -1, pieces));
        moves.addAll(lineMoves(-1, -1, pieces));
        moves.addAll(lineMoves(-1, 1, pieces));

        return moves;
    }

    private List<Coords> pawnMoves(List<Piece> pieces){
        List<Coords> moves = new ArrayList<Coords>();
        if(side.equals(Side.WHITE)){
            if(squareAvailable(new Coords(coords.x(), coords.y() + 1), pieces)){
                moves.add(new Coords(coords.x(), coords.y() + 1));
                if(squareAvailable(new Coords(coords.x(), coords.y() + 2), pieces)
                        && PieceUtil.doubleMoveRule(coords, side)){
                    moves.add(new Coords(coords.x(), coords.y() + 2));
                }
            }
            if(canEat(new Coords(coords.x() - 1, coords.y() + 1), pieces))
                moves.add(new Coords(coords.x() - 1, coords.y() + 1));
            if(canEat(new Coords(coords.x() + 1, coords.y() + 1), pieces))
                moves.add(new Coords(coords.x() + 1, coords.y() + 1));
        }
        if(side.equals(Side.BLACK)){
            if(squareAvailable(new Coords(coords.x(), coords.y() - 1), pieces)){
                moves.add(new Coords(coords.x(), coords.y() - 1));
                if(squareAvailable(new Coords(coords.x(), coords.y() - 2), pieces)
                        && PieceUtil.doubleMoveRule(coords, side)){
                    moves.add(new Coords(coords.x(), coords.y() - 2));
                }
            }
            if(canEat(new Coords(coords.x() - 1, coords.y() - 1), pieces))
                moves.add(new Coords(coords.x() - 1, coords.y() - 1));
            if(canEat(new Coords(coords.x() + 1, coords.y() - 1), pieces))
                moves.add(new Coords(coords.x() + 1, coords.y() - 1));
        }

        return moves;
    }

    //tee tornin ja lähetin liikkeestä funktiot niin kuningatar menee helposti
    private List<Coords> rookMoves(List<Piece> pieces){
        List<Coords> moves = straightMoves(pieces);
        return moves;
    }

    private List<Coords> knightMoves(List<Piece> pieces){
        List<Coords> moves = new ArrayList<Coords>();

        if(squareAvailable(new Coords(coords.x() - 1, coords.y() + 2), pieces)
                || checkSide(new Coords(coords.x() - 1, coords.y() + 2), pieces))
            moves.add(new Coords(coords.x() - 1, coords.y() + 2));

        if(squareAvailable(new Coords(coords.x() + 1, coords.y() + 2), pieces)
                || checkSide(new Coords(coords.x() + 1, coords.y() + 2), pieces))
            moves.add(new Coords(coords.x() + 1, coords.y() + 2));

        if(squareAvailable(new Coords(coords.x() - 2, coords.y() + 1), pieces)
                || checkSide(new Coords(coords.x() - 2, coords.y() + 1), pieces))
            moves.add(new Coords(coords.x() - 2, coords.y() + 1));

        if(squareAvailable(new Coords(coords.x() + 2, coords.y() + 1), pieces)
                || checkSide(new Coords(coords.x() + 2, coords.y() + 1), pieces))
            moves.add(new Coords(coords.x() + 2, coords.y() + 1));

        if(squareAvailable(new Coords(coords.x() - 2, coords.y() - 1), pieces)
                || checkSide(new Coords(coords.x() - 2, coords.y() - 1), pieces))
            moves.add(new Coords(coords.x() - 2, coords.y() + 1));

        if(squareAvailable(new Coords(coords.x() + 2, coords.y() - 1), pieces)
                || checkSide(new Coords(coords.x() + 2, coords.y() - 1), pieces))
            moves.add(new Coords(coords.x() + 2, coords.y() - 1));

        if(squareAvailable(new Coords(coords.x() - 1, coords.y() - 2), pieces)
                || checkSide(new Coords(coords.x() - 1, coords.y() - 2), pieces))
            moves.add(new Coords(coords.x() - 1, coords.y() - 2));

        if(squareAvailable(new Coords(coords.x() + 1, coords.y() - 2), pieces)
                || checkSide(new Coords(coords.x() + 1, coords.y() - 2), pieces))
            moves.add(new Coords(coords.x() + 1, coords.y() - 2));

        return moves;
    }

    private List<Coords> bishopMoves(List<Piece> pieces){
        List<Coords> moves = diagonalMoves(pieces);
        return moves;
    }

    private List<Coords> queenMoves(List<Piece> pieces){
        List<Coords> moves = new ArrayList<Coords>();
        moves.addAll(straightMoves(pieces));
        moves.addAll(diagonalMoves(pieces));

        return moves;
    }

    private List<Coords> kingMoves(List<Piece> pieces){
        List<Coords> moves = new ArrayList<Coords>();

        return moves;
    }

    public List<Coords> getMoves(List<Piece> pieces){
        List<Coords> moves = new ArrayList<Coords>();

        switch (pieceType){
            case PW -> moves = pawnMoves(pieces);
            case RK -> moves = rookMoves(pieces);
            case KN -> moves = knightMoves(pieces);
            case BH -> moves = bishopMoves(pieces);
            case QN -> moves = queenMoves(pieces);
            case KG -> moves = kingMoves(pieces);
        }

        return moves;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public Side getSide() {
        return side;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Coords getCoords() {
        return coords;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isClicked() {
        return clicked;
    }
}
