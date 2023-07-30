package com.apinanpaska.web.onlinechess.chessgame.websockets.models;

import com.apinanpaska.web.util.enums.Side;
import com.apinanpaska.web.util.records.Coords;

public record ClientState(
        int eventType,
        String clientID,
        String roomID,
        int pieceID,
        Coords pieceTarget, //palan kohde sijainti, voi olla myös null
        Side side
) {
}
