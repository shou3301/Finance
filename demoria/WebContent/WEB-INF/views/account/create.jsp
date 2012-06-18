<jsp:directive.include file="/WEB-INF/views/includes.jsp" />
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create Investment Account</title>
</head>
<body>
	<h1>Create your account, and begin to attract customers!</h1>
	<f:view>
		<form:form modelAttribute="accountCreateForm" method="POST"
			action="/demoria/account/create">
			<table>
				<tr>
					<td><form:label path="name" >Account Name</form:label></td>
					<td><form:input type="text" path="name" /></td>
				</tr>
			</table>

			<input type="submit" value="Submit" />
		</form:form>
	</f:view>
</body>
</html>