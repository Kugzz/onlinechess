//replace localhost with ip
const API = "http://localhost:8080";

const roomIDInput = document.querySelector('#roomIDInput');
const createGameButton = document.querySelector('#createGameButton');
const joinGameButton = document.querySelector('#joinGameButton');

const gameRooms = document.getElementsByClassName('gameRoom');

//vars
//testi
let token;

//const util functions
const setRoomIDInputValue = (e) => {
    roomIDInput.value = e.target.id; 
}

const getRoomIDInputValue = () => {
    return roomIDInput.value;
}
 
//server functions

const getToken = async () => {
    //hyvin keskeneräinen
    await fetch("http://localhost:8080/rest/getToken").then(result => result.text()).then(result => {
        token = result;
    })
}

const getGamePage = async (result) => {
    if(result.status != 0){
        //tee parempi error handling
        console.log("error in creating joining game");
        console.log(result.status);
        return
    }

    //TOKENI VAIHTUU KUN SIVUN RESETTAA!!!
    console.log(result);
    console.log(result.roomID());
    fetch(API + '/game/' + result.roomID);
}

const createGame = async () => {
    if(token == null) return;

    const response = fetch(API + "/rest/createGame",{
        method: "POST",
        body: JSON.stringify(new ConnectionClientModel(token, null)), 
        headers:{
            Accept: 'application/json',
            "Content-type": "application/json; charset=UTF-8"
        }

    }).then((result) => result.json()).then((result) => {
        console.log(result)
    })
}

const joinGame = async () => {
    console.log("join game")

    const response = await fetch(API + '/rest/connectClient', {
        method: "POST",
        body: JSON.stringify(new ConnectionClientModel(token, getRoomIDInputValue())),
        headers:{
            Accept: 'application/json',
            "Content-type": "application/json; charset=UTF-8"
        }
    }).then(result => result.json()).then(result => getGamePage(new ConnectionServerModel(result)));
}

createGameButton.addEventListener("click", createGame);
joinGameButton.addEventListener("click", joinGame);

Array.from(gameRooms).forEach(element => {
    element.addEventListener('click', setRoomIDInputValue);
})

//init
console.log("mainmenu");
getToken();