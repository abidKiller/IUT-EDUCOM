

//CHAT RELATED STUFFS
/*
function startChat()
{
   var username=document.getElementById("username");
   var password=document.getElementById("password");
   
   olist = document.getElementById('userName');
   
   if(username.value==''||password.value=='')
	   alert('please enter proper username and password');
   var xmlHttp;
   
   if(window.XMLHttpRequest){
	   xmlHttp = new XMLHttpRequest();
   }
   else{
	   xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	   
   }
   xmlHttp.open("POST","ChatEntry?username=" + username.value +"&password="+password.value, true);
   
   xmlHttp.onreadystatechange=function(){
	   if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
		   alert('done');
	   }
   } 
}

function sessionManager()
{
	var userName="abid";
	var s_id
	
	function getUsername()
	{
		return userName;
	}
	function gets_id()
	{
	    return s_id;
	}
	
	
    	
}
*/

function addText()
{
	//var userName=document.getElementById("username").value;
	var msg=document.getElementById("msg").value;
	if (msg=="")
		{
		  alert ("No Character Written ");
		  return ;
		}
	
	
	
	var xmlhttp;
	
	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest;	
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP")
	}
	
	xmlhttp.open("POST","ChatEntry?msg="+msg,true);
	
	
    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
           
        }
    }
    xmlhttp.send(null);
	
	
}

//when user changes group or logins again
function reloadChat()
{
  	//session will have specific g_id from which the messages will be reload
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP")
	}
	
	xmlhttp.open("POST","ChatReload",true);
	
	xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
        	
            document.getElementById("textTable").innerHTML = xmlhttp.responseText;
            //the html text written 
           
            
        }
    }
    xmlhttp.send(null);
}

//GROUP RELATED STUFF
function createGroup()
{
	
	var gName=document.getElementById("gname").value;
	var gKey=document.getElementById("genkey").value;
	
	if(gName==""||gKey==""){
		alert("input no input in Group name or Group Key ");
	}
	//var g_id=document.getElmentbyId("g_id").value
	else{
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	var groupTable=document.getElementById("groups");
	//alert("his");
	
	
	
	xmlhttp.open("POST","CreateGroup?gname="+gName+"&gkey="+gKey,true);
	
	xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
        	
    //    	<tr><td align="center" ><a class="mdc-button mdc-button--raised button-style" onclick="swichGroup();" ><span class="mdc-button__ripple"></span>cse 4253</a></td></tr>
            //the html text written
        	
        	if(xmlhttp.responseText=="no")
        	{
        		alert("maybe non unique group name");
        	}else{
        		
        		var child=document.createElement('g');
        		child.innerHTML="<tr><td align='center' ><a class='mdc-button mdc-button--raised button-style' onclick='switchGroup();' ><span class='mdc-button__ripple'></span>"+gName+"</a></td></tr><br><br>";
        	    
        		groupTable.appendChild(child);
        		
        		
        	}
        	
        	
        	   
            
        }
    }
    xmlhttp.send(null);	
   // loadGroups();
	}
}


function switchGroup(x)  // after pressing another group button only chat will change 
{
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	var groupTable=document.getElementById("groups");
	
	xmlhttp.open("POST","SwitchGroup?g_id="+x,true);
	xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
        	
         // alert(xmlhttp.responseText);
        	
        }
    }
    xmlhttp.send(null);
    
  
 
}

function joinGroup() // adding new group 
{
	alert("in join gorup");
	var gKey=document.getElementById("gkey").value;
	if(gKey=="")
		alert("input no input in Group name or Group Key ");
	else{
	//var g_id=document.getElmentbyId("g_id").value
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	var groupTable=document.getElementById("groups");
	//alert("his");
	
	
	
	xmlhttp.open("POST","EnterGroup?gkey="+gKey,true);
	
	xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
        	
    //    	<tr><td align="center" ><a class="mdc-button mdc-button--raised button-style" onclick="swichGroup();" ><span class="mdc-button__ripple"></span>cse 4253</a></td></tr>
            //the html text written
        	
        	if(xmlhttp.responseText=="no")
        	{
        		alert("No group found");
        	}else{
        		var child=document.createElement('div');
        		child.innerHTML=xmlhttp.responseText;
        	    
        		groupTable.appendChild(child); 
        		
        	}
        	
        	
        	   
            
        }
    }
    xmlhttp.send(null);	
    
    reloadEvent();
	}
}

function clicked(){
	return true;
}


function loadGroups()
{
	var xmlhttp;
	
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP")
	}
	var groupTable=document.getElementById("groups");
	
	xmlhttp.open("POST","LoadGroups",true);
	
	xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
        	
    //    	<tr><td align="center" ><a class="mdc-button mdc-button--raised button-style" onclick="swichGroup();" ><span class="mdc-button__ripple"></span>cse 4253</a></td></tr>
            //the html text written
        	
        	if(xmlhttp.responseText=="no")
        	{
        		
        	}else{
        		
        		var child=document.createElement('g');
        		child.innerHTML=xmlhttp.responseText;
        	    
        		groupTable.appendChild(child); 
        	}  
        }
    }
    xmlhttp.send(null);
}




//CALENDER EVENT STUFF 

function entryEvent()
{
	alert("HiIIH");
	 var date=document.getElementById("dt").value;
	 var text=document.getElementById("tt").value;
	 
	   var xmlhttp;
	  if (window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
	       xmlhttp = new XMLHttpRequest();
	   } else { // code for IE6, IE5
	       xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	   }

		xmlhttp.open("POST","EventEntry?date="+date+"&text="+text,true);
		
	    
		
		 
        
		xmlhttp.onreadystatechange = function(){
	        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
	        	
	  
	        		
	        }
	    }
	    xmlhttp.send(null);
	   
	    reloadEvent();
}

function reloadEvent()
{
	var xmlhttp;
	   if (window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
	       xmlhttp = new XMLHttpRequest();
	   } else { // code for IE6, IE5
	       xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	   }
    
	   
	   xmlhttp.open("POST","EventReload", true);
	   
	  
	   xmlhttp.onreadystatechange = function() {
	       if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
	    	
	    	  
	    	   var s=JSON.parse(xmlhttp.responseText);  //[{ "g_name":" " ,"date":{2020,8,21},"text": ""} ,{}]
	  
	    	  var events=[{"Date": new Date(2010, 8, 7), "Title": "boooom!"}];
	    	  
	    	  for(var i=0 ;i <s.length;i++)
	    	  {
	    		  var year,month,day;
	    		  year=s[i].date[0];
	    		  month=s[i].date[1]-1;
	    		  day= s[i].date[2];
	    		  
	    		 // alert(year+" "+month+" "+day);  
	    		  events.push({"Date": new Date(year, month, day), "Title": s[i].g_name+" : "+ s[i].text});
	    	  
	    	  } 
	    	  
	    	  
	    	  
	    	  //alert(JSON.stringify(events));
	    	  //calender()
	    	  
	    	  document.getElementById("fullbody").innerHTML='<div id="caleandar"> <script>setInterval(reloadEvent,10000);</script> </div>'
	    	  var settings = {};
	    	  var element = document.getElementById('caleandar');
	    	  caleandar(element, events, settings);
              
	    	    
	       }
	   }
	   xmlhttp.send(null);
	  
	
}

function reloadGroupName()
{
    var xmlhttp;
	
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP")
	}

	
	xmlhttp.open("POST","GetGroupName",true);
	
	xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
        	
    //    	<tr><td align="center" ><a class="mdc-button mdc-button--raised button-style" onclick="swichGroup();" ><span class="mdc-button__ripple"></span>cse 4253</a></td></tr>
            //the html text written
        	
        	if(xmlhttp.responseText=="no")
        	{
        		return;
        	}else{
        		
        		var g=document.getElementById("gname");
        		g.innerHTML=xmlhttp.responseText;
        		
        	}  
        }
    }
	
    xmlhttp.send(null);
	
}






