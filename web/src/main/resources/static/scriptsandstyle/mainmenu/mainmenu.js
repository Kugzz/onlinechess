//constants

//replace localhost with ip
const API = "http://localhost:8080";
const roomIDInput = document.querySelector('#roomIDInput');
const createGameButton = document.querySelector('#createGameButton');
const joinGameButton = document.querySelector('#joinGameButton');

//vars
//testi
let token;

//server functions

const getToken = async () => {
    //hyvin keskeneräinen
    await fetch("http://localhost:8080/rest/getToken").then(result => result.text()).then(result => {
        token = result;
    })
}

const createGame = async () => {
    if(token == null) return;

    const response = fetch(API + "/rest/createGame",{
        method: "POST",
        body: JSON.stringify({
            "clientID": token,
            "roomdID": null
        }),
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
}

createGameButton.addEventListener("click", createGame);
joinGameButton.addEventListener("click", joinGame);

//init
console.log("mainmenu");
getToken();