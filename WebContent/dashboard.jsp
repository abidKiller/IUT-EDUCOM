<html>
<head>
	<title>IUT - EDUCOM</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="./styles/loginRegister.css" rel="stylesheet">
    <link href="https://unpkg.com/material-components-web@v4.0.0/dist/material-components-web.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://unpkg.com/material-components-web@v4.0.0/dist/material-components-web.min.js"></script>
</head>

<body>
	<header>
		<img id="header-logo" src="./images/iuteducom.png" height="100px" width="100px" >
		<div id="login-reg-buttons">
			<a class="mdc-button mdc-button--raised button-style" href="./index.jsp">  <span class="mdc-button__ripple"></span> Logout</a>
		</div>
	</header>

	<div id="dashboard-menu">

		<a class="dashboard-menu-item" href="chat.jsp"><img src="./images/chat.png"></a>
		<a class="dashboard-menu-item" href="calendar.jsp"><img src="./images/calendar.png"></a>
		<a class="dashboard-menu-item" href="user.jsp"><img src="./images/user.png"></a>

	</div>


	<script src="./javascript/materialDesign.js"></script>
</body>
</html>