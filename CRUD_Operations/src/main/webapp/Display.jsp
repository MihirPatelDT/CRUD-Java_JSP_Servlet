<%@page import="MyPack.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

table{
background-color: green;
}
.first{
color : orange;
}
.second
{
color : lime;
}

</style>
<body>

<% ArrayList<Student>arrystu=(ArrayList<Student>)session.getAttribute("data"); %>

<a href="InsertData.jsp">Create User</a>
<br><br>
<table border="1" cellpadding="25px">

<tr class="first">
<th>RollNo</th>
<th>Name</th>
<th>Java</th>
<th>SL</th>
<th>LS</th>
<th>Percentage</th>
<th colspan="2">Action</th>
</tr>

<%for(Student stu : arrystu){ %>

<tr class="second">
<td><%=stu.rollno %></td>
<td><%=stu.name %></td>
<td><%=stu.java %></td>
<td><%=stu.sl %></td>
<td><%=stu.ls %></td>
<td><%=stu.perc +"%"%></td>
<td><a href="UpdateServlet?rollno=<%=stu.rollno %>">Edit</a></td>
<td><a href="DeleteServlet?rollno=<%=stu.rollno %>">Delete</a></td>
</tr>

<%} %>

</table>

</body>
</html>