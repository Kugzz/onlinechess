const saku = document.querySelector('#saku');
let tokenInited = false;
let token;

const getToken = async () => { 
    if(tokenInited) {
        console.log(token);
        return;
    }

    const res = await fetch("http://localhost:8080/rest/getToken").then(response => {
        response.text().then(result => {
            token = result;
            tokenInited = true;
            console.log(token);
        });
    });

}

//getrequestit

const redirectTest = async () => {
    console.log("kutsuu funktion");
    //const response = await fetch('http://localhost:8080/rest/apina').then(result => result.text()).then(result => console.log(result));
    const response = await fetch('http://localhost:8080/rest/apina').then(result => console.log(result));

    //console.log(response);
}

//post requestit

const createGame = async () =>{
    console.log("requesting data");

    await fetch("http://localhost:8080/rest/createGame",{
        method: "POST",
        body: JSON.stringify({
            "clientID": token,
            "roomdID": null
        }),
        headers:{
            Accept: 'application/json',
            "Content-type": "application/json; charset=UTF-8"
        }
    }).then((result) => result.text()).then(result => console.log(result));

    //tee createGame serverin puolelta
}   

const connectClient = async () => {
    console.log("connecting client")
    s = saku.value;

    await fetch("http://localhost:8080/rest/connectClient", {
        method: "POST",
        body: JSON.stringify({
            clientID: token,
            roomID: saku.value
        }),
        headers:{
            "Content-type": "application/json; charset=UTF-8"
        }
    }).then(result => result.json()).then(result => console.log(result));
}

const handlebutton = (e) => {
    if(!tokenInited) return;

    switch(e.key){
        case 'a':
            createGame();
            break;
        case 'd':
            connectClient();
            break;
        
        case 'w':
            redirectTest();
            break;
    }
}

getToken();
addEventListener("keydown", handlebutton);

