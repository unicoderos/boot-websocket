var ws;
function setConnected(connected) {

    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);

}

function connect() {

    ws = new WebSocket('ws://localhost:8080/user');
    ws.onmessage = function(data) {
        var messageIndex = data.data;
        displayRandomData(messageIndex);
    }

    setConnected(true);
}

function disconnect() {

    if (ws != null) {
        ws.close();
    }
    setConnected(false);
}

function sendData(name) {

    var data = JSON.stringify({
        'user' :name
    })

    ws.send(data);
}

function displayRandomData(message) {


    if(message.indexOf('google:')==0)
    {
        setRandomValue('#price',message.replace('google:',''));

    }
    if(message.indexOf('hotmail:')==0)
    {

        setRandomValue('#price1',message.replace('hotmail:',''));

    }
    if(message.indexOf('yahoo:')==0)
    {
        setRandomValue('#price2',message.replace('yahoo:',''));

    }
    if(message.indexOf('netflix:')==0)
    {

        setRandomValue('#price3',message.replace('netflix:',''));

    }
    if(message.indexOf('oracle:')==0)
    {
        setRandomValue('#price4',message.replace('oracle:',''));

    }
}

function setRandomValue(id, message){


    var floatOldVal = parseFloat($(id).val());
    $(id).val(message);
    newVal =message;
    if(newVal>floatOldVal){
        $(id).css('color','green');
    }
    else{
        $(id).css('color','red');
    }
}

$(function() {

    $("form").on('submit', function(e) {
        e.preventDefault();
    });

});
$( document ).ready(function() {

    connect();
    setInterval(function(){ sendData('google'); }, 5000);
    setInterval(function(){ sendData('hotmail'); }, 5000);
    setInterval(function(){ sendData('yahoo'); }, 5000);
    setInterval(function(){ sendData('netflix'); }, 5000);
    setInterval(function(){ sendData('orcale'); }, 5000);
});
