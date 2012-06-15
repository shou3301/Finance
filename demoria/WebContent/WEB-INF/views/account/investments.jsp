<jsp:directive.include file="/WEB-INF/views/includes.jsp" />
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Investments</title>
</head>
<body>
	<h1>Investments</h1>
	<table width="800px">
		<tr>
			<thead>
				<th>Id</th>
				<th>Unit</th>
				<th>Init Unit Price</th>
				<th>Transaction Date</th>
				<th>Product</th>
				<th />
				<th />
			</thead>
		</tr>
		<c:forEach items="${investments}" var="invest">
			<tr>
				<td>${invest.id}</td>
				<td>${invest.unit}</td>
				<td>${invest.initUnitPrice}</td>
				<td>${invest.transactionDate}</td>
				<td>${invest.product.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>