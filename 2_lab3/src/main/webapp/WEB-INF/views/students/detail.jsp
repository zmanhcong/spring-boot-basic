<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Student ID: ${student.studentId }</h3>
<h3> Name: ${student.name }</h3>
<h3> Email: ${student.email }</h3>
<h3> Hobbies: ${student.hobbies }</h3>
<h3> Name: ${student.gender }</h3>
<h3> Faculty: ${student.faculty }</h3>
<h3> image1: ${student.imageFile }</h3>
<h3> image2: ${msg }</h3>
<img src="/images/${student.imageUrl }" alt="Girl in a jacket" width="150" height="200">
</body>
</html>