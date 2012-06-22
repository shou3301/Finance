<jsp:directive.include file="/WEB-INF/views/includes.jsp" />
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Products</title>
</head>
<body>
<h1>All Products</h1>
	<table width="800px">
		<tr>
			<thead>
				<th>Id</th>
				<th>Name</th>
				<th>Description</th>
				<th>Management Fee</th>
				<th>Operations</th>
				<th />
				<th />
				<th />
			</thead>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.id}</td>
				<td><a href="/demoria/product/${product.id}">${product.name}</a></td>
				<td>${product.description}</td>
				<td>${product.managementFee}</td>
				<%-- <td><a href="/demoria/${account.key.id}/owners">owners</a></td> --%>
				<td><a href="/demoria/${product.id}/invest">Invest</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>