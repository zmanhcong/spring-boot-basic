<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="/">
</head>
<body>
 <h1> List of students</h1>
 <hr>
 <table>
	<tr>
		<td>Product ID</td>
		<td>Name</td>
		<td>Quantity</td>
		<td>Price</td>
		<td></td>

	</tr>
	<c:forEach var="item" items="${products}">
	<tr>
		<td>${item.productId}</td>
		<td>${item.name}</td>
		<td>${item.quantity}</td>
		<td>${item.price}</td>
		<td>
			<a href = "shoppingCart/add/${item.productId}">Add to cart</a>
		</td>
	</tr>
	</c:forEach>
 </table>
<a href="/shoppingCart/list">Shopping cart</a>
</body>
</html>