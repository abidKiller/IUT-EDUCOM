<html>
<head>
	<title>IUT - EDUCOM</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="./styles/chat_interface_sidebar.css" rel="stylesheet">
    <link href="https://unpkg.com/material-components-web@v4.0.0/dist/material-components-web.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://unpkg.com/material-components-web@v4.0.0/dist/material-components-web.min.js"></script>
     <script type="text/javascript" src="clientCode.js"></script>
</head>

<body>

	<input type="text" style="float:left;" name="chatRoomKey" placeholder="Enter Chat Room Key" id="gkey">
	<a class="mdc-button mdc-button--raised button-style" onclick="joinGroup();" >  <span class="mdc-button__ripple"></span>Join</a><br><br>
    
	<input type="text" style="float:left;" name="newChatRoomName" placeholder="Enter Chat Room Name" id="gname">
	<a class="mdc-button mdc-button--raised button-style" onclick="createGroup();">  <span class="mdc-button__ripple" ></span>Create</a>
    <input type="text" name="newChatRoomKey" style="float:left;" placeholder="Enter new Chat Room Key" id="genkey">
    
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
   
    <table id="groups" style=" margin-left: auto;margin-right: auto;">
      <script>loadGroups();</script>
      
    
    </table>
</body>

</html>