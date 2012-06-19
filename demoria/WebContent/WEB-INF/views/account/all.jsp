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
<title>Accounts</title>
</head>
<body>
	<h1>All Accounts</h1>
	<table width="800px">
		<tr>
			<thead>
				<th>Id</th>
				<th>Name</th>
				<th>Manager</th>
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
				<td>${account.key.id}</td>
				<td>${account.key.name}</td>
				<td>${account.key.manager.userName}</td>
				<td><a href="/demoria/${account.key.id}/owners">owners</a></td>
				<td><a href="/demoria/${account.key.id}/investments">investments</a></td>
				<td>
					<c:choose>
						<c:when test="${account.value==true}">
							<a href="/demoria/${user.id}/leaveaccount/${account.key.id}">Leave</a>
						</c:when>
						<c:otherwise>
							<a href="/demoria/${user.id}/addaccount/${account.key.id}">Join</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>