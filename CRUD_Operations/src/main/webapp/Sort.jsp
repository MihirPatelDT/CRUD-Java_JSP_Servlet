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
<body>
<%ArrayList<Student>arrystu=(ArrayList<Student>)session.getAttribute("Sortroll"); %>

<table border="1" cellpadding="25px">

<tr>
<th>RollNo</th>
<th>Name</th>
<th>Java</th>
<th>SL</th>
<th>LS</th>
<th>Percentage</th>
</tr>

<%for(Student stu : arrystu){ %>

<tr>
<td><%=stu.rollno %></td>
<td><%=stu.name %></td>
<td><%=stu.java %></td>
<td><%=stu.sl %></td>
<td><%=stu.ls %></td>
<td><%=stu.perc +"%"%></td>

</tr>

<%} %>

</table>


</body>
</html>