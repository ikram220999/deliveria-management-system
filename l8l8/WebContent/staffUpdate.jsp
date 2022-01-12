
<%@ page import = "java.util.*,staff.Staff" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="StaffModel" class="staff.StaffModel" scope="application" />
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

    <jsp:useBean id="staff" class="staff.Staff" scope="application" />
    
    <%  Staff iv = StaffModel.getStaffById (id);  %>
    
 <% List<staff.Staff> list = StaffModel.viewStaff(); %>
 
  <form action="StaffUpdate" method="post">
 <br><br>
<h4><b>Update Staff</b></h4>
 <br>
<div class="form-group col-md-5">	
  <div class="form-group">
 <label for="id">Staff ID </label>
    <input type="text" name="staffid" class="form-control" id="staffid"  value ="<%= iv.getStaffid() %>">
   </div>
   <div class="form-group">
  <label for="state"> Staff Name </label>
    <input type="text" name="staffname" class="form-control" id="staffname" value ="<%= iv.getStaffname() %>">
 </div>
 <div class="form-group">
 <label for="tel"> Staff Telephone </label>
 <input type="text" name="stafftel" class="form-control" id="stafftel" value ="<%= iv.getStafftel() %>">
 </div>

</div>
 <div class="form-group">
 <label for="tel"> Staff Position </label>
 <input type="text" name="staffpos" class="form-control" id="staffpos" value ="<%= iv.getStaffpos() %>">
 </div>

 <div class="form-group">
 <label for="tel"> Staff Branch </label>
 <input type="text" name="staffbranch" class="form-control" id="staffbranch" value ="<%= iv.getStaffbranch() %>">
 </div>

  <input type="hidden" name="id" value="<%= iv.getStaffid()%>">	
  <button type="submit" class="btn btn-primary">Update</button>
  <button type="button" class="btn btn-danger">Reset</button>
</form>
<jsp:include page = "footer.jsp"></jsp:include>
</body>
</html>
 