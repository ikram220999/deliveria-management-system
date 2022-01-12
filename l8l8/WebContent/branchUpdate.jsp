
<%@ page import = "java.util.*,branch.Branch" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="BranchModel" class="branch.BranchModel" scope="application" />
>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Branch Update</title>
  <jsp:include page = "header.jsp"></jsp:include>
</head>
<body>
    <% int id = Integer.parseInt(request.getParameter("id")); %>

    <jsp:useBean id="branch" class="branch.Branch" scope="application" />
    
    <%  Branch iv = BranchModel.getBranchById (id);  %>
    
 <% List<branch.Branch> list = BranchModel.viewBranch(); %>
 
  <form action="BranchUpdate" method="post">
 <br><br>
<h4><b>Update Branch</b></h4>
 <br>
<div class="form-group col-md-5">	
  <div class="form-group">
 <label for="id">Branch ID </label>
    <input type="text" name="id" class="form-control" id="id"  value ="<%= iv.getId() %>">
   </div>
   <div class="form-group">
  <label for="state"> Branch State </label>
    <input type="text" name="state" class="form-control" id="state" value ="<%= iv.getState() %>">
 </div>
 <div class="form-group">
 <label for="tel"> Branch Telephone </label>
 <input type="text" name="tel" class="form-control" id="tel" value ="<%= iv.getTel() %>">
 </div>

</div>
 <div class="form-group">
 <label for="tel"> Branch Address </label>
 <input type="text" name="address" class="form-control" id="address" value ="<%= iv.getAddress() %>">
 </div>


  <input type="hidden" name="id" value="<%= iv.getId()%>">	
  <button type="submit" class="btn btn-primary">Update</button>
  <button type="button" class="btn btn-danger">Reset</button>
</form>
<jsp:include page = "footer.jsp"></jsp:include>
</body>
</html>
 