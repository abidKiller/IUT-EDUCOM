import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class Db_handler {

	  private Connection con;
	  
	  public static void check()
	  {
		  
		   try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
				String sql="select groups.name ,a.day,a.text from (select * from events where s_id="+1+") a inner join groups on groups.g_id=a.g_id";

				String s2="select * from students ";  
			     	
				   Statement st=con.createStatement();
				 //  Statement st2=con.createStatement();
				   ResultSet rs=st.executeQuery(sql);
				 //  ResultSet rs2=st2.executeQuery(s2);
				 //  List<String > dates=new ArrayList();
				   String[] dates;
				   
					while(rs.next())
					   {
						dates=rs.getString(2).split("-",3);
						//System.out.println(dates);
						int[] idates= new int[3];
						for(int i=0;i<3;i++)
							idates[i]=Integer.parseInt(dates[i]);
						System.out.println(idates[0]+" "+idates[1]+" "+idates[2]);
						
						//idates=null;
						   
					   }
					
					
				  /*  
					
				   while(rs2.next()) {
					   System.out.println(rs2.getString(1));
				   }
				  */  
					//   System.out.println(dates);
	            
			}
			catch(Exception e){
				
				System.out.println(e);
			}
		   
		  
	  }
	   
	   public static void main(String args[])
	   { 
		   
		      SimpleDateFormat myformat= new SimpleDateFormat("yyyy-MM-dd");
		      SimpleDateFormat myformat2= new SimpleDateFormat("hh:mm:ss");
		      Date date=new Date();
		  try {
 		
		     String s = "insert into dummy values ( '" +myformat.format(date)+"'," + "'"+myformat2.format(date) +"')";
		     
		     System.out.println();
			   Db_handler m=new Db_handler();
			   m.connection();
			   m.executeQuery(s);
		  }
		  catch(Exception e) {
			  System.out.println(e);		  }
			 // Db_handler.'check();
			   
			   
 		    
		  
		  
	   }
	   
	public void connection()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","test123");
        
		}
		catch(Exception e){
			
			System.out.println(e);
		}
		 
	}
	
	ResultSet executeQuery(String sql)
	{
		ResultSet rs=null;
		try {
			Statement st=con.createStatement();
  
			rs=st.executeQuery(sql);
		}
		
		catch(Exception e){
			System.out.println(e);
			
		}
		
		try {
			con.close();
			con=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;	
	}	
}

