class clientValues{
    constructor(token, roomID) {
        this.token = token;
        this.roomID = roomID;
    }

    setSide(side){
        this.side = side;
    }
    //korjaa clientStatet, koska constructoris on nyt myös side
    //jatka clientValuesin kanssa ja muuta se vaan yheks olioks
}

class Coords{
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }

}

class Piece{
    constructor(piece) {
        this.id = piece.id;
        this.side = piece.side;
        this.pieceType = piece.pieceType;
        this.coords = piece.coords;
        this.alive = piece.alive;
        this.clicked = piece.clicked;
    }

    isAlive(){
        return this.alive;
    }
}

//client-side model for client messages
class ClientState{

    constructor(eventType, clientID, roomID, pieceID, pieceTarget, side) {
        this.eventType = eventType;
        this.clientID = clientID;
        this.roomID = roomID;
        this.pieceID = pieceID;
        this.pieceTarget = pieceTarget;
        this.side = side;
    }
    setDestination(clientID, roomID){
        this.clientID = clientID;
        this.roomID = roomID;
    }
}

//server-side model for server messages
class GameState {

    constructor(body) {
        this.gamePhase = body.gamePhase;
        this.pieces = body.pieces;
    }
}

class PieceData{
    constructor(body) {
        this.clientID = body.clientID;
        this.roomID = body.roomID;
        this.pieceID = body.pieceID;
        this.moves = body.moves;
    }
}