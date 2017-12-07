console.log("start");

var stompClient = null;


function connect(){
    var socket = new SockJS('/webSocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        
        // 구독한다.
        stompClient.subscribe('/topic/echoTest', function (message) {
            console.log('connect() message: ' + message);
        });
    });

}

function sendName() {
    stompClient.send("/assistant/echo", {}, JSON.stringify({'name': "name", "message": "message"}));
}



connect();
setTimeout(sendName, 1000);
