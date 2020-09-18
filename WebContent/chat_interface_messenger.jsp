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

	<div id="messageTextContainer">
		<input class="inputArea" type="text" name="messageText" placeholder="Type your message here..." id="msg" autocomplete="off">
	  	<a class="mdc-button mdc-button--raised button-style" onclick="addText();">  <span class="mdc-button__ripple"></span><img src="./images/send.png"></a>
	
	</div>
	<script>setInterval(reloadChat,3000);</script>
	<table id="textTable">
        
	</table>

	
</body>

</html>