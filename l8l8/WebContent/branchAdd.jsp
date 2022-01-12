<%@ page import = "java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="branch.Branch"%>
<jsp:useBean id="BranchModel" class="branch.BranchModel" scope="application"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<jsp:include page = "header.jsp"></jsp:include>
<br><br>
<h4><b>Add Branch</b></h4>
 <br>
<form action="BranchAdd" method="post">
<div class="form-group col-md-5">	
  <div class="form-group">
 <label for="id">Branch ID </label>
    <input type="text" name="id" class="form-control" id="id"  >
   </div>
   <div class="form-group">
  <label for="state"> Branch State </label>
    <input type="text" name="state" class="form-control" id="state"  >
 </div>
 <div class="form-group">
 <label for="tel"> Branch Telephone </label>
 <input type="text" name="tel" class="form-control" id="tel"  >
 </div>
</div>
 <div class="form-group">
 <label for="address"> Branch Address </label>
 <input type="text" name="address" class="form-control" id="address"  >
 </div>


 
  <button type="submit" class="btn btn-primary">Add</button>
  <button type="button" class="btn btn-danger">Reset</button>
</form>
 

<jsp:include page = "footer.jsp"></jsp:include>
</body>
</html>