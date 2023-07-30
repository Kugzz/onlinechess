package com.apinanpaska.web.onlinechess.chessgame.websockets.models;

import com.apinanpaska.web.onlinechess.chessgame.chess.Piece;
import com.apinanpaska.web.util.enums.GamePhase;

import java.util.List;

public record GameState(
        GamePhase gamePhase,
        List<Piece> pieces
) {
}
