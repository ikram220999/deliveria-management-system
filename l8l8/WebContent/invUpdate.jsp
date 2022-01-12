
<%@ page import = "java.util.*,inventory.Inventory" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="InventoryModel" class="inventory.InventoryModel" scope="application" />
>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delivery Update</title>
  <jsp:include page = "header.jsp"></jsp:include>
</head>
<body>
    <% String trackno = (request.getParameter("trackno")); %>

    <jsp:useBean id="inventory" class="inventory.Inventory" scope="application" />
    
    <%  Inventory iv = InventoryModel.getInventoryById (trackno);  %>
    
 <% List<inventory.Inventory> list = InventoryModel.viewInventory(); %>
 
  <form action="InventoryUpdate" method="post">
 <br><br>
<h4><b>Update Delivery</b></h4>
 <br>
<div class="form-group col-md-5">	
  <div class="form-group">
 <label for="trackno">Tracking no </label>
    <input type="text" name="trackno" class="form-control" id="trackno"  value ="<%= iv.getTrackno() %>">
   </div>
   <div class="form-group">
  <label for="state"> Sender Name </label>
    <input type="text" name="sendname" class="form-control" id="sendname" value ="<%= iv.getSendname() %>">
 </div>
 <div class="form-group">
 <label for="tel"> Sender Address </label>
 <input type="text" name="sendadd" class="form-control" id="sendadd" value ="<%= iv.getSendadd() %>">
 </div>

</div>
 <div class="form-group">
 <label for="tel"> Receiver Address </label>
 <input type="text" name="recadd" class="form-control" id="recadd" value ="<%= iv.getRecadd() %>">
 </div>


  <input type="hidden" name="trackno" value="<%= iv.getTrackno()%>">	
  <button type="submit" class="btn btn-primary">Update</button>
  <button type="button" class="btn btn-danger">Reset</button>
</form>
<jsp:include page = "footer.jsp"></jsp:include>
</body>
</html>
 