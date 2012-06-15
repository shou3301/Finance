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
<title>Insert title here</title>
</head>
<body>
	<f:view>
		<form:form modelAttribute="loginForm" method="POST"
			action="/demoria/login">
			<table>
				<tr>
					<td><form:label path="userName">Username</form:label></td>
					<td><form:input type="text" path="userName" /></td>
				</tr>

				<tr>
					<td><form:label path="password">password</form:label></td>
					<td><form:input type="password" path="password" /></td>
				</tr>
			</table>

			<input type="submit" value="Submit" />
		</form:form>
	</f:view>
</body>
</html>