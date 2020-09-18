
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ChatEntry")
public class ChatEntry extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		 //get text and g_id form parameter and s_id from session
		   if(request.getSession().getAttribute("g_id")==null)
		   {
			  
			   
		   }
		   
		   else
		   {
		    //int g_id=Integer.parseInt(sg_id);
		   String s_id=(String)(request.getSession().getAttribute("s_id"));
		    
		   String g_id=(String)(request.getSession().getAttribute("g_id"));
		  // int s_id=1;
		   //String userName="abid";
		   
		    String text= request.getParameter("msg");
		  //  String userName=(String)(request.getSession().getAttribute("username"));
		
		//entry the s_id,g_id,text in message table
		    
		   System.out.println(g_id+" "+text); 
		   
		   System.out.println("msg entry : "+g_id);
		   
		    try{
		    	
		    	 Date date=new Date();
		    	 SimpleDateFormat dayFormat= new SimpleDateFormat("yyyy-MM-dd");
			      SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm:ss");
			      
			      
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
				
				String sql="insert into messages values(message_seq.NEXTVAL,"+g_id+","+s_id+",'"+dayFormat.format(date)+"','"+timeFormat.format(date)+"','"+text+"') ";
				           
			    Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
			    con.close();
			    
			    //System.out.println(dates);
	            
			}
			catch(Exception e){
				
				System.out.println(e);
			}
		    
		    
		    
		   }
		doGet(request, response);
	}

}
