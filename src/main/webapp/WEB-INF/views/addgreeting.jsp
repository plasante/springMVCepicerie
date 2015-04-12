<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  		<title>Mon Epicerie</title>
	</head>
	<body>
		<h1>Mon Epicerie</h1>
		<form:form action="greetings.html" modelAttribute="greeting">
			<table>
				<tr>
					<td>Add your greeting:</td>
					<td><form:input path="greetingText" size="100" /></td>
					    <form:errors path="greetingText" />
					    <form:hidden path="id" />
				</tr>
				<tr>
					<td>What's your favorite color?</td>
					<td>
						<form:select path="colors">
							<form:option value="" label="--Please Select--"/>
							<form:options items="${colorlist}" itemValue="id" itemLabel="colorName"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" >
						<input type="submit" value="Submit" />
					</td>
				</tr>
			</table>
		</form:form>
	</body>
</html>