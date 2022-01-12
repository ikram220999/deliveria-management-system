package staff;

import java.io.IOException;
 
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InventoryUpdate
 */
@WebServlet("/StaffUpdate")
public class StaffUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		// read form fields
		response.setContentType("text/html");
		
	 
        
        Staff iv = new Staff();
   	 	 iv.setStaffid(Integer.parseInt(request.getParameter("staffid")));
   	 	 iv.setStaffname(request.getParameter("staffname"));
   	 	 iv.setStafftel(request.getParameter("stafftel"));
		 iv.setStaffpos(request.getParameter("staffpos"));
		 iv.setStaffbranch(Integer.parseInt(request.getParameter("staffbranch")));
		
		StaffModel im = new StaffModel();
		try{
		  im.updateStaff(iv);
		}
		catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		response.sendRedirect("staffView.jsp");
	}
	

}
