

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SwitchGroup")
public class SwitchGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String g_id=request.getParameter("g_id");
	    String m_id=request.getParameter("m_id");
		request.getSession().setAttribute("g_id",g_id);
		
        System.out.println(g_id);

	
		doGet(request, response);
	}

}
