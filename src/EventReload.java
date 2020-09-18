

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class EventReload
 */
@WebServlet("/EventReload")
public class EventReload extends HttpServlet {
	
	
	class events{
		String g_name;
		int[]  date;
		String text;
		
		events(String g_name,int[] date,String text)
		{
			this.g_name=g_name;
			this.date=date;
			this.text=text;
			
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		
		 String s_id =(String) request.getSession().getAttribute("s_id");
		 String  userName=(String) request.getSession().getAttribute("username");
		 System.out.println(userName);
		// fetch from database
		
		try{
	    	
	    	// Date date=new Date();
		      
		      
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
			
		   //	String sql="insert into messages ("+g_id+','+s_id+','+ "to_date('" +dayFormat.format(date)+"','yyyy-mm-dd')," + "'"+timeFormat.format(date)  +")";
			 
			String sql="select a.name ,a.day,a.text from( select groups.name,events.day,events.text,grp_to_student.s_id from events inner join grp_to_student on grp_to_student.g_id = events.g_id inner join groups on groups.g_id=grp_to_student.g_id) a where a.s_id="+s_id;
					


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
			List<events> userEvents=new ArrayList(); // java list of json elements
			String[] dates;
			   
			while(rs.next())
			   {
				dates=rs.getString(2).split("-",3);
				//System.out.println(dates);
				int[] idates= new int[3];
				for(int i=0;i<3;i++)
					idates[i]=Integer.parseInt(dates[i]);
				
				String groupName=rs.getString(1);
				String text=rs.getString(3);
				userEvents.add(new events(groupName,idates,text));
			   }

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			Gson gson=new Gson();
			String userJsonResponse=gson.toJson(userEvents);
			
			response.getWriter().write(userJsonResponse);
			
		    con.close();
		    rs.close();
		    st.close();
				  
		    //System.out.println(dates);
           
		}
		catch(Exception e){
			
			System.out.println(e);
		}
		
		
		
		//gson send 
		
		
		doGet(request, response);
	}

}
