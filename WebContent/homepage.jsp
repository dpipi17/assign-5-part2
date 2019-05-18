<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="sql_query.IQuery, model.Product, java.util.List, java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Student Store </title>
</head>
<body>

<h1> Student Store </h1>
<p> Items available: </p>

<ul>
	<% IQuery query = (IQuery)request.getServletContext().getAttribute("getQuery"); %>
	<% 	List<Product> prodList = query.selectAll();
		for(Product product : prodList) { %>
			<li> <a href="show-product.jsp?id=<%=product.getId()%>"> <%=product.getName() %> </a> </li>
	<%
	    }
	 %>
		
</ul>

</body>
</html>