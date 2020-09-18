<html>
<head>
	<title>IUT - EDUCOM</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="./styles/chat_interface_sidebar.css" rel="stylesheet">
    <link href="https://unpkg.com/material-components-web@v4.0.0/dist/material-components-web.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://unpkg.com/material-components-web@v4.0.0/dist/material-components-web.min.js"></script>
	<link rel="stylesheet" href="css/demo.css"/>
    <link rel="stylesheet" href="css/theme1.css"/>
	<link href="./styles/chat_interface_sidebar.css" rel="stylesheet">
	 <script type="text/javascript" src="clientCode.js"></script>
</head>
<body>
      <script> reloadEvent()</script>
	<div id="fullbody">
	     <div id="caleandar">
           <script>setInterval(reloadEvent,100000);</script>
         </div>
	</div>	
		<input type="date" id="dt">
		<input type="text" id="tt" value="Event info">
		
		<a class="mdc-button mdc-button--raised button-style" onclick="entryEvent();">  <span class="mdc-button__ripple"></span>set</a>
		<a class="mdc-button mdc-button--raised button-style" >  <span class="mdc-button__ripple"></span>delete</a><br><br>
		<script type="text/javascript" src="js/caleandar.js"></script>
       
	
		
</body>
</html>