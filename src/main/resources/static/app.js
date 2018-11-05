var ws;
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
}

function connect() {
    ws = new WebSocket('ws://localhost:8080/user');
    ws.onmessage = function(data) {
        helloWorld(data.data);
    }
    setConnected(true);
    console.log("connected");
}

function disconnect() {
    if (ws != null) {
        ws.close();
    }
    setConnected(false);
    console.log("Websocket is in disconnected state");
}

function sendData(name) {
    var data = JSON.stringify({
        'user' :name
    })
    ws.send(data);
}
i =1,tmp=0;
function helloWorld(message) {
    console.log(message);


    console.log(message.indexOf(':')+'t');
    if(message.indexOf('google:')==0)
    {
        console.log('working');
        work('#price',message.replace('google:',''));
        console.log(message.replace('google:','')+'tested');

    }
    if(message.indexOf('hotmail:')==0)
    {
        console.log('working');
        work('#price1',message.replace('hotmail:',''));
        console.log(message.replace('hotmail:','')+'tested');

    }
    if(message.indexOf('yahoo:')==0)
    {
        console.log('working');
        work('#price2',message.replace('yahoo:',''));
        console.log(message.replace('yahoo:','')+'tested');

    }
    if(message.indexOf('netflix:')==0)
    {
        console.log('working');
        work('#price3',message.replace('netflix:',''));
        console.log(message.replace('netflix:','')+'tested');

    }
    if(message.indexOf('oracle:')==0)
    {
        console.log('working');
        work('#price4',message.replace('oracle:',''));
        console.log(message.replace('oracle:','')+'tested');

    }

}
txt='';
function combinator(str,i){
    console.log(i+"ol");
    return txt;

}
function work(id,message){
    b = parseFloat($(id).val());
    $(id).val(message);
    a =message;
    if(a>b){
        console.log('a is  greater than b');
        $(id).css('color','green');
    }
    else{
        console.log('a is  lesser than b');
        $(id).css('color','red');
    }

    console.log(tmp);
}

$(function() {
    $("form").on('submit', function(e) {
        e.preventDefault();
    });
    $("#connect").click(function() {
        connect();
    });
    $("#disconnect").click(function() {
        disconnect();
    });
    $("#send").click(function() {
        sendData();
    });
});
$( document ).ready(function() {

    connect();
    setInterval(function(){ sendData('google'); }, 5000);
    setInterval(function(){ sendData('hotmail'); }, 5000);
    setInterval(function(){ sendData('yahoo'); }, 5000);
    setInterval(function(){ sendData('netflix'); }, 5000);
    setInterval(function(){ sendData('orcale'); }, 5000);
    console.log("hello");
});
