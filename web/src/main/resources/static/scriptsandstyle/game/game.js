console.log("hello world!!");

const chessboard = document.querySelector("#chessboard");

//test
const getToken = async () => {

    if(localStorage.getItem("token") == null){
        await fetch("http://localhost:8080/rest/getToken").then(result => result.text()).then(result => {
            localStorage.setItem("token", result);
            token = result;
        })
    }
    else token = localStorage.getItem("token");
}

//ws tests

let stompClient = null;

function connect(){
    let socket = new SockJS('/ws', [], {
        sessionId: () => {return token}
    });
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame){
       console.log(frame);
    
        //testit done! Voit alkaa tekee

       stompClient.subscribe("user/queue/reply", function (message){
           console.log("user/queue/reply ", message.body);
       });

       //user on websocketin id eikä token!!!!!!! 
       stompClient.subscribe("user/queue/data", function (message){
           console.log("user/queue/data ", message.body);
       })
    });
}

function sendMessage(){
    stompClient.send("/app/sendToUser/" + token, {}, "apina");
}


//loput
getToken().then(connect);

addEventListener("keydown", (e) => {
    if(e.key = 'k') sendMessage();
})