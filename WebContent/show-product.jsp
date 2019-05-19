<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="sql_query.IQuery, model.Product, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<% IQuery query = (IQuery)request.getServletContext().getAttribute("getQuery"); %>
<% Product product = query.getProduct(request.getParameter("id")); %>

<title> <%= product.getName() %></title>

</head>

<body>

<h1>  <%= product.getName() %> </h1>
<img src="store-images/<%= product.getImageFile() %>" alt="<%=product.getName() %>" width="200" height="213">

<br>
<form action="CardServlet" method="post"> 
	$<%= product.getPrice() %> <input name="productid" type="hidden" value="<%= product.getId() %>"/> 
    <button type="submit"> Add to Cart </button> 
</form>

</body>
</html>