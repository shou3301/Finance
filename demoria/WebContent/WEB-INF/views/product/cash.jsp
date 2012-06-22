<jsp:directive.include file="/WEB-INF/views/includes.jsp" />
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${product.name}</title>
</head>
<body>
	<h1>${product.name}</h1>
	<ul>
		<li>Name: ${product.name}</li>
		<li>Description: ${product.description}</li>
		<li>Management Fee: ${product.managementFee}</li>
		<li>Interest: ${product.interest}</li>
	</ul>
</body>
</html>