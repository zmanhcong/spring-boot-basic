<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/students/saveOrUpdate" method="post" modelAttribute="student"
		enctype="multipart/form-data">
		
		Student ID: <form:input path="studentId" /> <br />
		Name: <form:input path="name" /> 
		<span id="name.errors" style="color:red" class="error">name is required!</span>
		<br />
		Email: <form:input path="email" />  
		<span id="name.email" style="color:red" class="error">email is required!</span>
		 <br />
		Mark: <form:input path="mark" /> <form:errors path="mark"/> <br />
		Faculty: 
		<form:select path="faculty" items="${faculties}"></form:select>
		<br />
		Gender:
		<form:radiobuttons path="gender" items="${genders}" />
		<br />
		Hobbies:
		<form:checkboxes path="hobbies" items="${hobbies}"/>
		<br />
		<input type="file" name ="imageFile" /> <br />
		
		<form:button>Save</form:button>
	</form:form>
</body>
</html>