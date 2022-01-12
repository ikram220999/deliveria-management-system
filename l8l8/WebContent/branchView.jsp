
<%@ page import = "java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page = "header.jsp"></jsp:include>
</head>
<body>

<jsp:useBean id="BranchModel" class="branch.BranchModel" scope="application" />

<% List<branch.Branch> list = BranchModel.viewBranch(); %>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


<br>

<h3>Index page here</h3>
<p>
	content for index page should be here <br>
	Your role is 
	<% if(session.getAttribute("role") != null) {
			if(session.getAttribute("role").equals("admin")) {
	%>
				administrator.
	<% 
			}
			else if(session.getAttribute("role").equals("user")){ %>
				user.
	<%		}
		} %>
</p>


<table class="table table-hover">
     <thead class="thead-light">
    <tr>
    <th>Id</th>
    <th>State</th>
    <th>Tel</th>
    <th>Address</th>
    <th>Actions<th>
    </tr>

<%


    for(branch.Branch i : list) {%>


        <tr>
        <td><%=i.getId() %></td>
        <td><%=i.getState() %></td>
        <td><%=i.getTel() %></td>
        <td><%=i.getAddress() %></td>
      
  
<td> <form action="branchUpdate.jsp" method="POST">
                  <input type="hidden" name="id" value="<%= i.getId() %>">
                <button type="submit" class="btn btn-warning">Update</button>
                   </form>
             </td>
                    
 
              <td> <form action="BranchDelete" method="POST">
                  <input type="hidden" name="id" value="<%= i.getId() %>">
                  <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure to delete this record?')">Delete</button> 
                  </form>
              </td>
              
        <br>
        
        </tr>

<%    }

%>
</table>

<br>
<jsp:include page="footer.jsp"></jsp:include>


