package inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.*;
import java.sql.* ;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/InventoryUpdate")
public class InventoryUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public InventoryUpdate(){
		super();
	}

	
//3
//Muhammad Ikram bin Azhar
//2020980817
//RCS2404C
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		 	 	 
		Inventory iv = new Inventory();
		 iv.setTrackno(request.getParameter("trackno"));
		 iv.setSendname(request.getParameter("sendname"));
		 iv.setSendadd(request.getParameter("sendadd"));
		 iv.setRecadd(request.getParameter("receiveadd"));

		 
		 InventoryModel im = new InventoryModel();
		 try {	 
			im.updateInventory(iv);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}

		 
		 HttpSession session = request.getSession();
         session.setAttribute("success", "Succesfully updated");
	 
		 response.sendRedirect("invView.jsp");
	}
	
}
