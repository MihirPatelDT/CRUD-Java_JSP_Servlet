<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% String usr=(String) session.getAttribute("usr"); %>
<h2><%out.print("Welcome : "+usr); %></h2><br><br>


<form  action="InsertServlet" method="GET">

Enter RollNo : <input type="text" name="rollno"><br><br>
Enter Name : <input type="text" name="name"><br><br>
Enter Java :  <input type="text" name="java"><br><br>
Enter SL :  <input type="text" name="sl"><br><br>
Enter LS :  <input type="text" name="ls"><br><br>


<input type="submit" value="Submit">
</form><br>
<form  action="DisplayServlet" method="GET">
<input type="submit" value="Display">
</form><br>
<form  action="Search.html" method="GET">
<input type="submit" value="Search">
</form><br>
<form  action="SortedServlet" method="GET">
<input type="submit" value="SortByRollNo">
</form><br>
<form  action="Sorted1Servlet" method="GET">
<input type="submit" value="SortByPerc">
</form><br>
<form  action="Sorted2Servlet" method="GET">
<input type="submit" value="SortByName">
</form><br>



</body>
</html>