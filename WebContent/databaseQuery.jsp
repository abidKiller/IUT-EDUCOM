<html>
<head>
	<title>IUT-EDUCOM</title>
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="./styles/loginRegister.css" rel="stylesheet">
    <link href="https://unpkg.com/material-components-web@v4.0.0/dist/material-components-web.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://unpkg.com/material-components-web@v4.0.0/dist/material-components-web.min.js"></script>
</head>
<body>
	<header>
		<img id="header-logo" src="./images/iuteducom.png" height="100px" width="100px" >
	</header>

	<%@ page import="java.sql.*" %>

	<%
		String id=request.getParameter("userId");
		String pass=request.getParameter("userPassword");
		session.setAttribute("s_id",id);
		

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn;
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");

			Statement stmt;
			stmt=conn.createStatement();

			String sql;
			sql="select * from students where s_id='"+id+"' and password='"+pass+"'";
			Boolean ret = false;
			ret = stmt.execute(sql);
		
			
			ResultSet rs = stmt.executeQuery(sql);
            
			if(rs.next()==true)
			{
				session.setAttribute("username", rs.getString(2));
				out.println("<h1>Log in sucessful!</h1>");
				response.sendRedirect("./dashboard.jsp");
			}

			else
			{
				out.println("<h1>User Not Found!</h1>");
			}
		}

		catch(Exception e)
		{
			out.println("<h1>ERROR!</h1>");
			out.println(e);
		}

	%>

	<script src="./javascript/materialDesign.js"></script>

</body>
</html>