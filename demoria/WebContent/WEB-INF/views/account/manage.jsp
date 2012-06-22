<jsp:directive.include file="/WEB-INF/views/includes.jsp" />
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Manage Accounts</title>
</head>
<body>
<jsp:directive.include file="/WEB-INF/views/header.jsp" />
<h1>Manage Accounts</h1>
	<table width="800px">
		<tr>
			<thead>
				<th>Id</th>
				<th>Name</th>
				<th>Owner</th>
				<th>Investments</th>
				<th>Operations</th>
				<th />
				<th />
				<th />
			</thead>
		</tr>
		<c:forEach items="${accounts}" var="account">
			<tr>
				<td>${account.id}</td>
				<td>${account.name}</td>
				<td><a href="/demoria/${account.id}/owners">owners</a></td>
				<td><a href="/demoria/${account.id}/investments">investments</a></td>
				<td><a href="/demoria/${account.manager.id}/${account.id}/manage">manage</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>