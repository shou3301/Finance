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
<title>Sign up</title>
</head>
<body>
	<f:view>
		<form:form modelAttribute="signupForm" method="POST"
			action="/demoria/signup">
			<table>
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input type="text" path="firstName" /></td>
				</tr>

				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input type="text" path="lastName" /></td>
				</tr>
				
				<tr>
					<td><form:label path="userName">Username</form:label></td>
					<td><form:input type="text" path="userName"/></td>
				</tr>

				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input type="text" path="email" /></td>
				</tr>
				
				<tr>
					<td><form:label path="password1">password</form:label></td>
					<td><form:input type="password" path="password1" /></td>
				</tr>
				
				<tr>
					<td><form:label path="password2">re-password</form:label></td>
					<td><form:input type="password" path="password2" /></td>
				</tr>
				
				<tr>
					<td><form:label path="streetName">Street Name</form:label></td>
					<td><form:input type="text" path="streetName" /></td>
				</tr>
				
				<tr>
					<td><form:label path="streetNum">Street Num</form:label></td>
					<td><form:input type="text" path="streetNum" /></td>
				</tr>
				
				<tr>
					<td><form:label path="zipcode">Zip Code</form:label></td>
					<td><form:input type="text" path="zipcode" /></td>
				</tr>
				
				<tr>
					<td><form:label path="city">City</form:label></td>
					<td><form:input type="text" path="city" /></td>
				</tr>
				
				<tr>
					<td><form:label path="state">State</form:label></td>
					<td><form:input type="text" path="state" /></td>
				</tr>
			</table>

			<input type="submit" value="Submit" />
		</form:form>
	</f:view>
</body>
</html>