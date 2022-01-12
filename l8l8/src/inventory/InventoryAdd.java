
 package inventory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



 /**
 * Servlet implementation class InventoryAdd
 */
 @WebServlet("/InventoryAdd")
 public class InventoryAdd extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
 * @see HttpServlet#HttpServlet()
 */
 public InventoryAdd() {
 super();
 // TODO Auto-generated constructor stub
 }

//2
//Muhammad Ikram bin Azhar
//2020980817
//RCS2404C
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

	 
	 PrintWriter out = response.getWriter();
 Inventory iv = new Inventory();
 iv.setTrackno(request.getParameter("trackno"));

 iv.setSendname(request.getParameter("sendname"));
 iv.setSendadd(request.getParameter("sendadd"));

 iv.setRecadd(request.getParameter("receiveadd"));
 
 
 

 try{
	  
	  InventoryModel im = new InventoryModel();
	  im.addInventory(iv);
	  out.println("<b>Successfully Inserted"
             + "</b>");
	}
 catch (SQLException | ClassNotFoundException e) {

 e.printStackTrace();
 }



 HttpSession session = request.getSession();
/* session.setAttribute("success", "Succesfully Added"); */

 response.sendRedirect("invView.jsp");


 }

 }


