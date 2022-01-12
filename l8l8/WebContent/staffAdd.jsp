<%@ page import = "java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="staff.Staff"%>
    <%@ page import="branch.Branch"%>
<jsp:useBean id="StaffModel" class="staff.StaffModel" scope="application"></jsp:useBean>
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
<form action="StaffAdd" method="post">
<div class="form-group col-md-5">	
  <div class="form-group">
 <label for="id">Staff ID </label>
    <input type="text" name="staffid" class="form-control" id="staffid"  >
   </div>
   <div class="form-group">
  <label for="state"> Staff Name </label>
    <input type="text" name="staffname" class="form-control" id="staffname"  >
 </div>
 <div class="form-group">
 <label for="tel"> Staff Telephone </label>
 <input type="text" name="stafftel" class="form-control" id="stafftel"  >
 </div>
</div>
 <div class="form-group">
 <label for="staffpos"> Staff Position </label>
 <input type="text" name="staffpos" class="form-control" id="staffpos"  >
 </div>


 <div class="form-group">
 <label for="staffpos"> Staff Branch </label>
 <input type="text" name="staffbranch" class="form-control" id="staffbranch"  >
 </div>

 
  <button type="submit" class="btn btn-primary">Add</button>
  <button type="button" class="btn btn-danger">Reset</button>
</form>
 

<jsp:include page = "footer.jsp"></jsp:include>
</body>
</html>