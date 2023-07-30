class ConnectionClientModel{

    constructor(clientID, roomID){
        this.clientID = clientID;
        this.roomID = roomID;
    }
}

class ConnectionServerModel{
  
    constructor(object){
        this.status = object.status;
        this.clientID = object.clientID;
        this.roomID = object.roomID;
    }
}