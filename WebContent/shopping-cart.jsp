<%@page import="model.ShopCart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="sql_query.IQuery, model.Product, java.util.List, java.util.ArrayList" %>
<%@ page import="java.util.Set, java.util.HashSet" %>
<!DOCTYPE html>
<html>

<% 
	Set<Product> cartProducts = new HashSet<Product>();
	IQuery query = (IQuery)request.getServletContext().getAttribute("getQuery");
	ShopCart cart = (ShopCart)request.getSession().getAttribute("shoppingcart");
	
	Set<String> ids = cart.allIds();
	for(String id : ids) {
		Product product = query.getProduct(id);
		cartProducts.add(product);
	}
	
	double totalResult = 0;
	for(Product product : cartProducts) {
		totalResult += (product.getPrice() * cart.getOccur(product.getId()));
	}
%>

<head>
<meta charset="ISO-8859-1">
<title> Shopping Cart </title>
</head>
<body>

<h1> Shopping Cart </h1>

<form action="CardServlet" method="post">
    <ul>
        <% 	for(Product product : cartProducts) { %>
    		
    		<li> <input type= "number" value = "<%=cart.getOccur(product.getId()) %>"  name="<%= product.getId() %>">
    		 		<%= product.getName() %>, <%= product.getPrice() %>
    		 </li>
    		
    	<% 
    		}
        %>
            
    </ul>
    Total: $ <%= totalResult %> <button type="submit"> Update Cart </button>
</form>

<a href="homepage.jsp"> Continue Shopping </a>

</body>
</html>