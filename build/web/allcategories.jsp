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
            <td><a href="categoryinfo.jsp">Category Info</a></td>
            <td><a href="addcategory.jsp">Add Category</a></td>
            <td><a href="${pageContext.request.contextPath}/AllCategories" >All Categories</a></td>            
        </table>
        <table border="1" align="center" >
            <th>ID</th>
            <th>Name</th>
            <th>Tax</th>
            <th>SubCategories On This Category</th>
            <c:forEach items="${requestScope.list}" var="category">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/GetCategory?id=${category.id}">${category.id}</a></td>
                    <td>${category.name}</td>
                    <td>${category.tax}</td>
                    <td>${category.subcategoryList}</td>
                    
                </tr>
            </c:forEach>                 
        </table>
    </body>
</html>
