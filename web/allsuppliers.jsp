<%-- 
    Document   : allcategories
    Created on : May 11, 2015, 11:59:50 PM
    Author     : VolkanOzkan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="adminindex.jsp" />
        <title>Category</title>
    </head>
    <body>
        <table border="1" align="center" >
            <th>name</th>
            <th>city</th>
            <th>Phone</th>
            <th>Email</th>
            <c:forEach items="${requestScope.list}" var="suppliers">
                <tr>
                    <td>${suppliers.name}</td>
                    <td>${suppliers.phone}</td>
                    <td>${suppliers.city}</td>
                    <td>${suppliers.email}</td>
                    
                </tr>
            </c:forEach>                 
        </table>
    </body>
</html>
