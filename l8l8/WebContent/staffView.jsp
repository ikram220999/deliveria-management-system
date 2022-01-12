
<%@ page import = "java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page = "header.jsp"></jsp:include>
</head>
<body>

<jsp:useBean id="StaffModel" class="staff.StaffModel" scope="application" />

<% List<staff.Staff> list = StaffModel.viewStaff(); %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


<br>



<table class="table table-hover">
     <thead class="thead-light">
    <tr>
    <th>Staff ID</th>
    <th>Staff Name</th>
    <th>Staff Tel</th>
    <th>Staff Position</th>
    <th>Branch<th>
    <th>Action<th>
    </tr>

<%


    for(staff.Staff i : list) {%>


        <tr>
        <td><%=i.getStaffid() %></td>

        <td><%=i.getStaffname() %></td>
        <td><%=i.getStafftel() %></td>
        <td><%=i.getStaffpos() %></td>
      	 <td><%=i.getStaffbranch() %></td>
  

                    
  <td> <form action="staffUpdate.jsp" method="POST">
                  <input type="hidden" name="id" value="<%= i.getStaffid() %>">
                  <button type="submit" class="btn btn-warning">Update</button> 
                  </form>
              </td>
              <td> <form action="StaffDelete" method="POST">
                  <input type="hidden" name="id" value="<%= i.getStaffid() %>">
                  <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure to complete this delivery?')">Delete</button> 
                  </form>
              </td>
              
        <br>
        
        </tr>

<%    }

%>
</table>

<br>
<jsp:include page="footer.jsp"></jsp:include>


