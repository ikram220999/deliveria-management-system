package branch;

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
@WebServlet("/BranchUpdate")
public class BranchUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchUpdate() {
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
		
	 
        
        Branch iv = new Branch();
   	 	 iv.setId(Integer.parseInt(request.getParameter("id")));
   	 	 iv.setState(request.getParameter("state"));
   	 	 iv.setTel(request.getParameter("tel"));
		 iv.setAddress(request.getParameter("address"));
	
		
		BranchModel im = new BranchModel();
		try{
		  im.updateBranch(iv);
		}
		catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		response.sendRedirect("branchView.jsp");
	}
	

}
