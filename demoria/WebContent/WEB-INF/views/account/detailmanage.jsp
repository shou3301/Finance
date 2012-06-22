<jsp:directive.include file="/WEB-INF/views/includes.jsp" />
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<jsp:directive.include file="/WEB-INF/views/header.jsp" />
<h1>Manage Account ${account.name}</h1>

<h2>Add investments</h2>
<a href="/demoria/products">Check out available products</a>

<h2>Manage Account Investors</h2>
	<table width="800px">
		<tr>
			<thead>
				<th>Owner Id</th>
				<th>Owner Name</th>
				<th>Operations</th>
				<th />
				<th />
				<th />
			</thead>
		</tr>
		<c:forEach items="${account.owners}" var="owner">
			<tr>
				<td>${owner.id}</td>
				<td>${owner.userName}</td>
				<td><a href="/demoria/${account.id}/remove/${owner.id}">remove</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>