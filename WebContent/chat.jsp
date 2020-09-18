<html>
<head>
	<title>IUT - EDUCOM</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="./styles/loginRegister.css" rel="stylesheet">
    <link href="https://unpkg.com/material-components-web@v4.0.0/dist/material-components-web.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://unpkg.com/material-components-web@v4.0.0/dist/material-components-web.min.js"></script>
     <script type="text/javascript" src="clientCode.js"></script>
</head>

<body>
	<header>
		<img id="header-logo" src="./images/iuteducom.png" height="100px" width="100px" >
		<div id="login-reg-buttons">

			<a class="mdc-button mdc-button--raised button-style" href="./index.jsp">  <span class="mdc-button__ripple"></span> Logout</a>
		</div>
	</header>
	   
	 <h2 id='uname' style='position:relative; left:40px; text-shadow: 2px 2px #fff;color:red;'><%=session.getAttribute("username")%></h2>
	   <script>setInterval(reloadGroupName,3000);</script>
      <h2 id='gname' style='text-align: center;  text-shadow: 2px 2px #fff;color: red;'></h2>
      <script>setInterval(reloadGroupName,3000);</script>

	<div id="chat-interface">
		
		<iframe style="overflow:hidden; display:inline-block; position: relative; height: 100%;" class="chat-interface-item" width="25%" src="chat_interface_sidebar.jsp">
			
		</iframe>

		<iframe style="overflow:hidden; display:inline-block; position: relative; height: 100%;" class="chat-interface-item" width="50%" src="./calendar.jsp">
			
		</iframe>

		<iframe style="overflow:hidden; display:inline-block; position: relative; height: 100%;" class="chat-interface-item" width="22%" src="chat_interface_messenger.jsp">
			
		</iframe>

	</div>

	<script src="./javascript/materialDesign.js"></script>
</body>
</html>