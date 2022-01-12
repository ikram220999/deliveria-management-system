
<%@page import="java.util.*" %>
<%@page import="inventory.InventoryModel" %>
<jsp:useBean id="obj" scope="application" class="inventory.InventoryModel"/>

<% List<inventory.Inventory> list = InventoryModel.viewInventory(); %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<jsp:include page="header.jsp"></jsp:include>
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
    <th>Track no</th>
    <th>Sender Name</th>
    <th>Sender Address</th>
    <th>Receiver Address</th>
    <th>Actions<th>
    </tr>

<%


    for(inventory.Inventory i : list) {%>


        <tr>
        <td><%=i.getTrackno() %></td>

        <td><%=i.getSendname() %></td>
        <td><%=i.getSendadd() %></td>
        <td><%=i.getRecadd() %></td>
      
  

                    
 
              <td> <form action="InventoryDelete" method="POST">
                  <input type="hidden" name="trackno" value="<%= i.getTrackno() %>">
                  <button type="submit" class="btn btn-warning" onclick="return confirm('Are you sure to complete this delivery?')">Complete</button> 
                  </form>
              </td>
              
        <br>
        
        </tr>

<%    }

%>
</table>

<br>
<jsp:include page="footer.jsp"></jsp:include>


