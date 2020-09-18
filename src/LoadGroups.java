

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


@WebServlet("/LoadGroups")
public class LoadGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

        String s_id=(String)(request.getSession().getAttribute("s_id"));
      //  String userName=(String) request.getSession().getAttribute("username");
       
    int g_id=1;
	  
	    try{
	    	
	    	 Date date=new Date();
		      
		      
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
			
		   //	String sql="insert into messages ("+g_id+','+s_id+','+ "to_date('" +dayFormat.format(date)+"','yyyy-mm-dd')," + "'"+timeFormat.format(date)  +")";
			 
			//String sql="select a.day,a.time,a.text,students.user_name from (select * from messages where g_id=" +g_id+")a inner join students on students.s_id=a.s_id order by a.m_id";
             String sql="select groups.name,groups.g_id from (select * from grp_to_student where s_id="+s_id+") a inner join groups on a.g_id=groups.g_id";
			
		    Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			PrintWriter r=response.getWriter();
			response.setContentType("text/html");
			while(rs.next())
			{
				// write to response 
				String s=rs.getString(2);
				 
				 r.print("<tr><td align='center'><a  class='mdc-button mdc-button--raised button-style g_id' id='"+s+"' onclick='switchGroup(id);' onkeypress='clicked();' ><span class='mdc-button__ripple'></span>"+rs.getString(1)+"</a></td></tr><br><br>");
				 
			}
			r.close();
				  
		    //System.out.println(dates);
          
		}
		catch(Exception e){
			
			System.out.println(e);
		}
	    
	
		
		doGet(request, response);
	}

}
