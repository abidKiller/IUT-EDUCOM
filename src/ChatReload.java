

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChatReload
 */
@WebServlet("/ChatReload")
public class ChatReload extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   
	    
	    
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        	//get s_id and s_id and username from session
	        // int g_id= 1;
		     if(request.getSession().getAttribute("g_id")==null) {
		    	
		    	 
				  response.setContentType("text/html");
				  response.getWriter().print("no");
				  response.getWriter().close();
		     }
		     
		     else {
		      String g_id=(String)(request.getSession().getAttribute("g_id"));
		    //  System.out.println(g_id);
	          String s_id=(String)(request.getSession().getAttribute("s_id"));
	        //  String userName=(String ) request.getSession().getAttribute("username");
	         
	        //  int g_id=1;
		  
		    try{
		    	
		    	 Date date=new Date();
			      
			      
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
				
			   //	String sql="insert into messages ("+g_id+','+s_id+','+ "to_date('" +dayFormat.format(date)+"','yyyy-mm-dd')," + "'"+timeFormat.format(date)  +")";
				 
				String sql="select a.day,a.time,a.text,students.user_name from (select * from messages where g_id="+g_id+")a inner join students on students.s_id=a.s_id order by a.m_id";

				
			    Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				PrintWriter r=response.getWriter();
				response.setContentType("text/html");
				while(rs.next())
				{
					// write to response 
					 String text =rs.getString(3);
					 String timing=rs.getString(2)+' '+rs.getString(1);
					 
					 
					 
					 // write html response
					 
					 r.print("<tr><td><h5 style='color: red'><input style='display:none' type='text' id='g_id' value='"+g_id +"'>"+rs.getString(4)+" :</h5></td> <td><h5>"+text +"</h5> <span style='font-size: 60%'>"+ timing+"</span></td></tr> ");
					 
					 
				}
				r.close();
					  
			    //System.out.println(dates);
	            
			}
			catch(Exception e){
				
				System.out.println(e);
			}
		    
		 
		     }
		 
		doGet(request, response);
		
	}

}
