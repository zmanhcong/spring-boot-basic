<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="/">
</head>
<body>
 <h1> Student Detail</h1>
 <hr>

<h3>Student ID: ${studentId}</h3>
<h3>Name: ${ name }</h3>

<p>
	<a href="/students/edit/${studentId}"> Edit Student</a>
</p>
<hr>

<a href="/" > Home </a>
		
</body>
</html>