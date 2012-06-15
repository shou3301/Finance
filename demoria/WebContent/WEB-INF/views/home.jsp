<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Home</title>
</head>
<body>
	<h1>Welcome ${uname}!</h1>
	<ul>
		<li><a href="/demoria/${uname}/profile">Your profile</a></li>
		<li><a href="/demoria/${uname}/accounts">Your accounts</a></li>
		<li><a href="/demoria/accounts">Show all accounts</a></li>
	</ul>
</body>
</html>