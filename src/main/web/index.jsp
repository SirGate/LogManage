<%@ page import="java.util.Date" %>
<%@ page import="java.util.Collections" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="com.LogManage.web.TestBean" %>
<%@ page import="com.LogManage.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSP page</h1>

<%
    EntityManager em= (EntityManager) application.getAttribute("em");
    TestBean bean = new TestBean();
    bean.setup(em);
%>

<%= new Date().toString() %>

<table>
    <tbody>
    <% for(User user: bean.getUsers ()){ %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getLogin() %></td>
    </tr>
    <% } %>
    </tbody>
</table>






</body>
</html>
