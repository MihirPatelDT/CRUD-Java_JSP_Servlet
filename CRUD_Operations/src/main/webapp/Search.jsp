<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h2>Search Results</h2>
    <table border="1" cellpadding="25px">
        <tr>
            <th>Roll No</th>
            <th>Name</th>
            <th>Java</th>
            <th>SL</th>
            <th>LS</th>
            <th>Percentage</th>
        </tr>
        <%-- Iterate through the search results and display each row --%>
        <%
        ResultSet rs = (ResultSet) request.getAttribute("RS");
            while(rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("rollno") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("java") %></td>
            <td><%= rs.getInt("sl") %></td>
            <td><%= rs.getInt("ls") %></td>
             <td><%= rs.getFloat("percentage") %></td>
        </tr>
        <% } %>
    </table>

</body>
</html>