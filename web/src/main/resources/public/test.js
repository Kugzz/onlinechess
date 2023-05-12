console.log("hello world");

//luo tokeni eka


//getrequestit

//post requestit

const createGame = async (e) =>{
    if(e.key != 'a') return;
    console.log("requesting data");

    const response = await fetch("http://localhost:8080/rest/createGame",{
        method: "POST",
        body: JSON.stringify({
            "clientID": "abcdefg",
            "roomdID": "null"
        }),
        headers:{
            Accept: 'application/json',
            "Content-type": "application/json; charset=UTF-8"
        }
    }).then((result) => result.text()).then(result => console.log(result));
    console.log("done");
    console.log(response);
    console.log(response.body);

    //tee createGame serverin puolelta
}

const connectClient = async () => {

    const response = await fetch("http://localhost:8080/rest/connectClient", {
        method: "POST",
        body: JSON.stringify({
            clientID: "abcdee",
            roomID: "apina"
        }),
        headers:{
            "Content-type": "application/json; charset=UTF-8"
        }
    })
}


addEventListener("keydown", createGame);