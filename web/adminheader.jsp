<%-- 
    Document   : adminheader
    Created on : May 12, 2015, 11:01:44 PM
    Author     : VolkanOzkan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <link rel="stylesheet" href="/SoftwareHw/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Admin Panel</title>
</head>
<body background="img/vava.png">

<center>
<br />
<nav>
	<ul>
		<li><a href="adminindex.jsp">Home Page</a></li>
		<li><a href="addcategory.jsp">Category</a>
			<ul>
				<li><a href="categoryinfo.jsp"> Category Info</a></li>
				<li><a href="${pageContext.request.contextPath}/AllCategories">All Categories</a></li>
                                <li><a href="addcategory.jsp"> Add Category</a></li>
			</ul>
		</li>
		<li><a href="${pageContext.request.contextPath}/CategoryChoose">SubCategory</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/AllSubCategories">All subCategory</a></li>
                                <li><a href="${pageContext.request.contextPath}/CategoryChoose"> Add subCategory</a></li>
			</ul>
		</li>
		<li><a href="${pageContext.request.contextPath}/AddProductChoose">Product</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/AllProducts">All Products</a></li>
				<li><a href="showbooksview.jsp">Show Books(View)</a></li>
				<li><a href="addproduct.jsp">Add Product</a></li>
				<li><a href="increaseprice.jsp">Increase Product Prices (SP)</a></li>
			</ul>
		</li>
		<li><a href="${pageContext.request.contextPath}/AllSuppliers">Supplier</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/AllSuppliers">Suppliers</a></li>
			</ul>
		</li>
	</ul>
</nav>
</center>

