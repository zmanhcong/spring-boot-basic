<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Shopping Cart</h2>
<hr>
    <table>
        <tr>
            <td>No. </td>
            <td>Name</td>
            <td>Quantity</td>
            <td>Price</td>
            <td></td>
        </tr>
        <c:set var="no" value="1"></c:set>
        <c:forEach var="item" items="${cartItems}">
            <form action="/shoppingCart/update/${item.productId}" method="post" >
                <tr>
                    <td>${no}</td>
                    <td>${item.name}</td>
                    <td>
                         <input type="hidden" name="productId" value="${item.productId}">  <%--id is hidden: ta không hi?n th? ra ?? user không s?a ???c--%>
                        <input type="number" value="${item.quantity}" name="quantity"
                               onblur="this.form.submit()">    <%--onblur : input xong click ra khoi form thi duoc submit--%>
                    </td>
                    <td>${item.price*item.quantity}</td>
                    <td>
                        <a href="/shoppingCart/remove/${item.productId}">Remove</a>
                    </td>
                </tr>
            </form>
            <c:set var="no" value="${no + 1}"></c:set>  <%--c:set la setting tu dong tang (No1, No2..vv)number--%>
        </c:forEach>
    </table>
    <a href="/products/list">Product List</a>
    <a href="/shoppingCart/checkout">Checkout</a>


</body>
</html>