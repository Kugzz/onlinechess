package com.apinanpaska.web.util.chessgameutil;

import com.apinanpaska.web.util.enums.Side;
import com.apinanpaska.web.util.records.Coords;

public class PieceUtil {

    public static boolean doubleMoveRule(Coords coords, Side side){
        if(side.equals(Side.WHITE) && coords.x() != 2) return false;
        if(side.equals(Side.BLACK) && coords.y() != 7) return false;
        return true;
    }
}
