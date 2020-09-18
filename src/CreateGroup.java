

import java.io.IOException;
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

/**
 * Servlet implementation class CreateGroup
 */
@WebServlet("/CreateGroup")
public class CreateGroup extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String gName=request.getParameter("gname");
		  String gKey = request.getParameter("gkey");
		  String s_id=(String)request.getSession().getAttribute("s_id");
		 
		  boolean sameFound = false;
		 
			  try 
			  {
				  Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
					
				//	String sql="insert into messages values(message_seq.NEXTVAL,"+g_id+","+s_id+",'"+dayFormat.format(date)+"','"+timeFormat.format(date)+"','"+text+"') ";
					 
					String sql="select * from groups where name='"+gName+"' or gen_key='" +gKey+"'";
					 Statement st=con.createStatement();
					  ResultSet rs=st.executeQuery(sql);
					  if(rs.next()) {
						  sameFound=true;
						  response.setContentType("text/html");
						  response.getWriter().print("no");
						  response.getWriter().close();
						  con.close();
						  st.close();
						  rs.close();
						  
						
					  }
					  
					  
					
			  }catch(Exception e)
			  {
				  System.out.println(e);
			  }
			  
		  if(sameFound==false) {
	    try{
	    	
	    	 Date date=new Date();
	    	 SimpleDateFormat dayFormat= new SimpleDateFormat("yyyy-MM-dd");
		     SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm:ss");
		      
		      
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
			
		//	String sql="insert into messages values(message_seq.NEXTVAL,"+g_id+","+s_id+",'"+dayFormat.format(date)+"','"+timeFormat.format(date)+"','"+text+"') ";
			 
			String sql="insert into groups values(group_sq.NEXTVAL,'"+gName+"','"+gKey+"')";
			String sql2="insert into grp_to_student values(group_sq.currval,"+s_id+")";
		    Statement st=con.createStatement();
		    Statement st2=con.createStatement();
		    ResultSet rs=st.executeQuery(sql);
		    ResultSet rs2=st.executeQuery(sql2);
		
		    con.close();
	        st.close();
	        rs.close();
	        st2.close();
	        rs2.close();
	        
		    //System.out.println(dates);
            
		}
		catch(Exception e){
			
			System.out.println(e);
		}
	}

	    
	doGet(request, response);
}
	


}
