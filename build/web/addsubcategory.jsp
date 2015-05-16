<%-- 
    Document   : addcategory
    Created on : May 13, 2015, 1:15:29 AM
    Author     : VolkanOzkan
--%>
<%-- 
    Document   : categoryinfo
    Created on : May 11, 2015, 11:58:26 PM
    Author     : VolkanOzkan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/SoftwareHw/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="adminindex.jsp" />
        <title>Category</title>
    </head>
    <body>
        <table align="center" border="1">
            <td><a href="${pageContext.request.contextPath}/CategoryChoose">Add SubCategory</a></td>
            <td><a href="${pageContext.request.contextPath}/AllSubCategories">All SubCategories</a></td>            
        </table>
        <form action="${pageContext.request.contextPath}/SubCategoryServlet" method="POST">
            <table align="center" border="2">
              
                <tr>
                    <td>ID:</td>
                    <td><input type="hidden" name="id" value="0"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${subcategory.name}" required="true"/></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><input type="text" name="description" value="${subcategory.description}" /></td>
                </tr>
                 <tr> 
                    <td>Category:</td>
                    <!--<td><input type="text" name="catid" value="${subcategory.categoryid}" required="true" /></td>-->
                   <td> <select name = "catid">
                    <c:forEach items="${requestScope.list}" var="category">
                        <option value="${category.id}"> ${category.name} </option>
                    </c:forEach>    
                </select></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="Submit" name="operation" value="Add" />
                </tr> 
            </table>
        </form>
               
                 
    </body>
</html>
