<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
 <%@ page import="inventory.*" %>
<%@ page import = "java.util.*" %>
<jsp:useBean id="InventoryModel" scope="application" class="inventory.InventoryModel"
/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
 <jsp:include page = "header.jsp"></jsp:include>
 <h2>Add new delivery</h2><br>



<form action="InventoryAdd" method="POST">

 <div class="form-group">
<label for="trackno">Tracking no</label>
 <input type="text" name="trackno" class="form-control" id="trackno"
>
 </div>
 
 <div class="form-group">
 <label for="sender">Sender Name</label>
 <input type="text" name="sendname" class="form-control"
id="sendname" >
 </div>
 
<div class="form-group">
 <label for="sendadd">Sender Address</label>
 <textarea class="form-control" name="sendadd" id="sendadd"
rows="4" ></textarea>
 </div>
 <br>
 -------------------------------------------------------------------------------------------------------------------------------------------------
<br><br>

 
<div class="form-group">
 <label for="receiveadd">Receiver Address</label>
 <textarea class="form-control" name="receiveadd" id="receiveadd"
rows="4" ></textarea>
 </div>
 
<button type="submit" class="btn btn-primary">Add</button>
 </form>

 </body>
 </html>

 <jsp:include page="footer.jsp"></jsp:include>