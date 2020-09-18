

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetGroupName
 */
@WebServlet("/GetGroupName")
public class GetGroupName extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getSession().getAttribute("g_id")==null)
		{
	         response.setContentType("text/html");
	         response.getWriter().print("no");
			
		}
		
		else {
		String g_id=(String) request.getSession().getAttribute("g_id");
		try{
		  	
	    	 Date date=new Date();
		      
		      
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
			
		   //	String sql="insert into messages ("+g_id+','+s_id+','+ "to_date('" +dayFormat.format(date)+"','yyyy-mm-dd')," + "'"+timeFormat.format(date)  +")";
			 
			//String sql="select a.day,a.time,a.text,students.user_name from (select * from messages where g_id=" +g_id+")a inner join students on students.s_id=a.s_id order by a.m_id";
            String sql="select name from groups where g_id="+g_id;
			
		    Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			PrintWriter r=response.getWriter();
			response.setContentType("text/html");
			if(rs.next())
			{
				// write to response 
				 
				 r.print("<h2 id='gname' style='text-align: center;  text-shadow: 2px 2px #ff000;color: red;'>"+rs.getString(1) +"</h2>"); 
			}
			else
				r.print("<h2 id='gname' style='text-align: center;  text-shadow: 2px 2px #fff;color: red;'> no groups</h2>"); 
			
			r.close();
			con.close();
            st.close();
            rs.close();
		}
		catch(Exception e) {
			
		}
		doGet(request, response);
	}
	}
}
