<html>
    <head>
        <title>
            IUT - EDUCOM
        </title>
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
                <a class="mdc-button mdc-button--raised button-style" href="./index.jsp">  <span class="mdc-button__ripple"></span> Login</a>
                <a class="mdc-button mdc-button--raised button-style" href="./register.jsp">  <span class="mdc-button__ripple"></span> Register</a>
            </div>
        </header>

        <div id="form">
            <form method="POST" action="databaseQuery.jsp">
                <label id="form-title">Log-in</label><br><br>
                <input class="form-field" type="text" name="userId" placeholder="User ID"><br><br>
                <input class="form-field" type="password" name="userPassword" placeholder="Password"><br><br>
                <input class="mdc-button mdc-button--raised button-style" type="submit" value="Login">
            </form>
        </div>
    <script src="./javascript/materialDesign.js"></script>
    </body>
</html>