package com.apinanpaska.web.onlinechess.chessgame.websockets.models;

import com.apinanpaska.web.util.records.Coords;

import java.util.List;

public record PieceData(
        String clientID,
        String roomID,
        int pieceID,
        List<Coords> moves
) {
}
