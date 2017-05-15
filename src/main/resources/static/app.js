var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
	//var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect(
    		{}, 
    		function (frame) 
    		{
        		setConnected(true);
        		console.log('Connected: ' + frame);
        		stompClient.subscribe('/topic/greetings', function (greeting) 
        		{
        			//alert("Ciao" + (greating.body).content);
        			showGreeting(JSON.parse(greeting.body).content);
        			console.log((greeting.body).content);
        						
        		}
        						);
    		},
    		function(err) 
    		{
    					// connection error
    			console.log("Sono dentro err della connect!!!");
    		}
    		);
    
  
}

function disconnect() {
    if (stompClient != null) 
    {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}


function connectmetro()
{
	connect();
	return;
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});