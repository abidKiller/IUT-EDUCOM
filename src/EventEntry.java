

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



/**
 * Servlet implementation class EventEntry
 */
@WebServlet("/EventEntry")
public class EventEntry extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get parameter to varible
		
		String date=request.getParameter("date");
		String g_id=(String)request.getSession().getAttribute("g_id");
	    String text=(String) request.getParameter("text");
		
		// insert in database
try{
	    	
	    	// Date date=new Date();
		      
		      
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
			
		   //	String sql="insert into messages ("+g_id+','+s_id+','+ "to_date('" +dayFormat.format(date)+"','yyyy-mm-dd')," + "'"+timeFormat.format(date)  +")";
			 
			String sql="insert into events values(1,"+g_id+",'"+date+"','"+text+"')";
			
			


		    /*	
			create table events(
					s_id number,
					g_id number,
					day varchar(10),
					text varchar(100)
				);
           */
			
		    Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
		    con.close();
		    rs.close();
		    st.close();
				  
		
           
		}
		catch(Exception e){
			
			System.out.println(e);
		}
		
		
		
		
		
		doGet(request, response);
	}

}
