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

var conversazione=null;
conversazione = window.location.search.substring(1);

function connect() 
{
    var socket = new SockJS('/gs-guide-websocket');
	//var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    document.getElementById('topic').innerHTML=conversazione;
    
    //var id= document.getElementById("link").getAttribute("href");
    //var id=document.getElementById("topic");
  
    
    stompClient.connect
    (
    		{}, 
    		function (frame) 
    		{
        		setConnected(true);
        		console.log('Connected: ' + frame);
        		var name='/topic/_' + conversazione ; 	//può valere /topic/BusMetro, /topic/Traffico, /topic/GiroBici
        		var chat="chat"+conversazione;
        		stompClient.subscribe(name, function (chat) 
        		{
        			//alert("Ciao" + (greating.body).content);
        			//var metodo="chat" + conversazione;
        			
        			showGreeting(JSON.parse(chat.body).content);
        			console.log((chat.body).content);
        						
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

function disconnect() 
{
    if (stompClient != null) 
    {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() 
{
	
 
    
    var nome="/app/" + conversazione;
    
    
    //stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}))
    stompClient.send(nome, {}, JSON.stringify({'name': $("#name").val()}));
    
}

function showGreeting(message) 
{
	console.log("Sono dentro showGreeting");
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
	
}






$(function () 
{
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { 
    	
    	connect();
    		});
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { 
    	
    	sendName(); 
    	$("#name").val('');
   });
});



$( document ).ready(function() 
{	//con questo metodo la connessione avviene in automatico. Eliminarlo in caso di problemi
	//conversazione = window.location.search.substring(1);
    //var url=window.location.href ;
    //url=url.split("?");
    
    
   
    //window.history.pushState('',document.title,url[0]);
    
	connect();
});



