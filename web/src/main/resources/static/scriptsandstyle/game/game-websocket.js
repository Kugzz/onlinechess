//chess

const chessboard = document.querySelector("#chessboard");
console.log(chessboard);

//websockets

const API = 'http://localhost:8080';
let token;
let roomID;
let stompClient = null;

//client-side messages
function loadGameState(){
    stompClient.send("/app/loadGameState", {}, JSON.stringify({clientID: token, roomID}));
}

function clientEvent(clientState){

    clientState.setDestination(token, roomID);
    stompClient.send("/app/clientEvent", {}, JSON.stringify(clientState));
}

//server-side messages
function updateGameState (message){
    let gameState = new GameState(JSON.parse(message.body));

    console.log(gameState.pieces);
    //chessboard.updateBoard(gameState.pieces);
    chessboard.updateBoard(gameState.pieces.map(piece => new Piece(piece)));

    console.log("update gameState");
}

function updateMoves(message){
    let pieceData = new PieceData(JSON.parse(message.body));
    chessboard.addMoves(pieceData);

    console.log(pieceData);
}

//setup websockets
function connect(){
    let socket = new SockJS('/ws', [], {
        sessionId: () => {return token}
    });
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame){
       console.log(frame);

       //testi
       stompClient.subscribe("/user/" + token + "/reply", function (message){});

       //data which the client requests
       stompClient.subscribe("/user/" + token + "/loadGameState", updateGameState);

       stompClient.subscribe("/user/" + token + "/pieceData", updateMoves);

       //for server-side updates
       stompClient.subscribe("/topic/gameState/" + roomID, updateGameState);

       //load the current state of the game
       loadGameState();
    });
}

async function getToken() {

    if(localStorage.getItem("token") == null){
        await fetch(API + "/rest/getToken").then(result => result.text()).then(result => {
            localStorage.setItem("token", result);
            token = result;
        })
    }
    else token = localStorage.getItem("token");
}

function getRoomID(){
    let url = window.location.href;
    roomID = url.substring(url.lastIndexOf('/') + 1);
}


getRoomID();
getToken().then(connect);