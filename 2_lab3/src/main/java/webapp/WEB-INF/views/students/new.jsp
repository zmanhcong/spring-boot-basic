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
	<h1> New student</h1>
	<hr/>
	<form action="students/saveOrUpdate" method="post">
		Student ID: <input type = "text" name = "studentId"> <br />
		Name: <input type="text" name="name"> <br />
		<button> Save</button>  
		<button formmethod="get" formaction="students/list"> List</button>  
		<button formmethod="get" formaction="students/search"> Search</button>  
	</form>
</body>
</html>