

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
 * Servlet implementation class EnterGroup
 */
@WebServlet("/EnterGroup")
public class EnterGroup extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String s_id=(String)(request.getSession().getAttribute("s_id"));
	      //  String userName=(String) request.getSession().getAttribute("username");
	       String gKey=request.getParameter("gkey");
	  		  
		    try{
		    	
		    	 Date date=new Date();
			      
			      
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
				
	   //         String sql="select groups.name,groups.g_id from (select * from grp_to_student where s_id="+s_id+") a inner join groups on a.g_id=groups.g_id";
	              
				String sql="select groups.name,groups.g_id from groups where gen_key='"+gKey+"'";
				
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				
				if(rs.next()) {
					
				String gName=rs.getString(1);
				int g_id = rs.getInt(2);
				
				st.close();
				rs.close();
				String sql2="insert into grp_to_student values("+g_id+","+s_id+")";
				
			    Statement st2=con.createStatement();
				ResultSet rs2=st2.executeQuery(sql2);
				PrintWriter r=response.getWriter();
				response.setContentType("text/html");
				while(rs2.next())
				{
					// write to response 
					 r.print("<tr><td align='center'><a class='mdc-button mdc-button--raised button-style' id ='"+g_id+"'onclick='switchGroup(id);' ><span class='mdc-button__ripple'></span>"+gName+"</a></td></tr><br><br>");
				}
				r.close();
				}
				
					  
			    //System.out.println(dates);
	          
			}
			catch(Exception e){
				
				System.out.println(e);
			}
		    
	 
		doGet(request, response);
		
	}

}
