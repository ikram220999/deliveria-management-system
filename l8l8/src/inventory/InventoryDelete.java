package inventory;

 import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 /**
 * Servlet implementation class InventoryDelete
 */

 @WebServlet("/InventoryDelete")
 public class InventoryDelete extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
 * @see HttpServlet#HttpServlet()
 */
 public InventoryDelete() {
 super();
 // TODO Auto-generated constructor stub
 }


 protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
 // TODO Auto-generated method stub
 response.getWriter().append("Served at: ").append(request.getContextPath());
 }

 
 
//4
//Muhammad Ikram bin Azhar
//2020980817
//RCS2404C
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {


 String trackno = (request.getParameter("trackno"));

 InventoryModel im = new InventoryModel();
 try {
 im.deleteInventoryById(trackno);
 } catch (SQLException | ClassNotFoundException e) {

 e.printStackTrace();
 }



 HttpSession session = request.getSession();
 session.setAttribute("danger", "Deleted");


 response.sendRedirect("invView.jsp");
 }

 }


