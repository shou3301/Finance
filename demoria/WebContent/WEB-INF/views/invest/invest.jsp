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
<title>Make Investment</title>
</head>
<body>
<jsp:directive.include file="/WEB-INF/views/header.jsp" />
	<h1>Choose your account and make your investment</h1>

	<form:form modelAttribute="investForm" method="POST"
		action="/demoria/${pid}/invest">
		<form:select path="accountId">
			<c:forEach items="${accounts}" var="account">
				<form:option value="${account.id}">${account.name}</form:option>
			</c:forEach>
		</form:select>
		<form:label path="amount">Amount</form:label>
		<form:input type="text" path="amount" />
		<input type="submit" value="Submit" name="submit" />
	</form:form>
</body>
</html>