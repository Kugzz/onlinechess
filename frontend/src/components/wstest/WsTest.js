import { useState, useEffect } from "react";
import useScript from "../hooks/UseScript.js";

function WsTest(){
    useScript("https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js");

    var stompClient = null;
    var socket = new SockJS('http://localhost:8080/wsapi')
    stompClient = Stomp.over(socket);

    //koita saada sockJS ja scriptit toimii
    useEffect(() => {
        
    }, []);

    return(
        <div>
           
        </div>
    );
}

export default WsTest;