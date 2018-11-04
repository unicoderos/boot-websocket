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

function helloWorld(message) {
	i =0;
	value = new Array(100);
	tmp = $("#price").val();
	console.log(tmp);
	value[i]=message;
	$("#price").val(message);
	
	if(tmp>value[i]){
		
		$("#price").css('color','red');
		}
	else{
		console.log('yes');
		$("#price").css('color','green');
		
	}
	i++;
	
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
    // starts infinite requests
    connect();
    setInterval(function(){ sendData('google'); }, 5000)/*sends infinite requests*/;
	});
