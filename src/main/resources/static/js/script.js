var stompClient = null;

window.onload = connect();

function connect() {
    var socket = new SockJS('/hello');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function(greeting){
            showGreeting(JSON.parse(greeting.body).content);
            showQty(JSON.parse(greeting.body).qty);
            setQty(JSON.parse(greeting.body).cur,JSON.parse(greeting.body).id);
        });
    });
}

function sendName() {
    var name = 'товар';
    stompClient.send("/app/hello", {}, JSON.stringify({ 'name': name }));
}

function showGreeting(message) {
    console.log(message);
    document.getElementById("resultInput").value=message;
}

function showQty(message) {
    console.log(message);
    document.getElementById("resultQty").value='В корзине ' +  message + ' шт. товара.';
}

function setQty(cur,id) {
    console.log(cur,id);
    // document.getElementById("tableCart").getElementsByTagName("input").value=' ';
    document.getElementById('myProd'+id).innerHTML=cur;
}