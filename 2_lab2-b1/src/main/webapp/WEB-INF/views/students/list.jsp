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
 		<td>Student Id</td>
 		<td>Name</td>
 		<td></td>
 	</tr>
 	
 	<c:forEach var="item" items="${students}">
 	 <tr>
 		<td>${item.studentId}</td>
 		<td>${item.name}</td>
 		<td>
 		<a href="/students/viewDetail/${item.studentId}">View</a> |
 		<a href="/students/edit/${item.studentId}">Edit</a> |
 		<a href="/students/delete/${item.studentId}">Delete</a> |
 		</td>
 	</tr>
 	</c:forEach>
 </table>

</body>
</html>