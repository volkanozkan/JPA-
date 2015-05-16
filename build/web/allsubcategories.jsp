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
            <td><a href="${pageContext.request.contextPath}/CategoryChoose">Add SubCategory</a></td>
            <td><a href="${pageContext.request.contextPath}/AllSubCategories">All SubCategories</a></td> 
        </table>
        <table border="1" align="center" >
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>In</th>
            <c:forEach items="${requestScope.list}" var="subcategory" >
                <tr>
                    <td><a href="${pageContext.request.contextPath}/GetSubCategory?id=${subcategory.id}">${subcategory.id}</a></td>
                    <td>${subcategory.name}</td>
                    <td>${subcategory.description}</td>
                     <td>${subcategory.categoryid}</td>
            </tr>
            </c:forEach>  
              


        </table>

    </body>
</html>
