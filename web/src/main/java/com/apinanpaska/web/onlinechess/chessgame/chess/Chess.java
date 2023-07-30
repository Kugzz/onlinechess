package com.apinanpaska.web.onlinechess.chessgame.chess;

import com.apinanpaska.web.onlinechess.chessgame.websockets.WebSocketController;
import com.apinanpaska.web.onlinechess.chessgame.websockets.models.ClientState;
import com.apinanpaska.web.onlinechess.chessgame.websockets.models.GameState;
import com.apinanpaska.web.onlinechess.chessgame.websockets.models.PieceData;
import com.apinanpaska.web.util.chessgameutil.ChessUtil;
import com.apinanpaska.web.util.enums.GamePhase;
import com.apinanpaska.web.util.records.Coords;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Chess {

    List<Piece> pieces;
    GamePhase gamePhase;

    public Chess(){

        pieces = ChessUtil.createPieces();
    }

    public void startGame(){

    }

    //keskeneräinen
    public GameState getGameState(){
        //pakkaa gamestate ennen kuin lähetät
        return new GameState(gamePhase, pieces);
    }

    public PieceData requestPieceData(ClientState clientState){
        List<Coords> moves = pieces.get(clientState.pieceID()).getMoves(pieces);
        return new PieceData(clientState.clientID(), clientState.roomID(), clientState.pieceID(), moves);
    }

}
