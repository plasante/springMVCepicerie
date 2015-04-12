<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
		<h1>Edit Greeting</h1>
		
		<c:url var="action" value="/home/updategreeting.html" />
		<form:form method="POST" action="${action}" modelAttribute="greeting" commandName="greeting">
			<table>
				<tr>
					<td>
						<form:label path="id">
							ID
						</form:label>
					</td>
					<td>
						<form:input path="id" disabled="true"/>
						<form:hidden path="id" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="greetingText">Greeting</form:label>
					</td>
					<td>
						<form:input path="greetingText" />
						<form:errors path="greetingText" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="">
							Colors
						</form:label>
					</td>
					<td>
						<form:select path="colors" id="greetinColor.id">
							<c:forEach items="${colorlist}" var="color">
								<c:set var="found" value="false" />
								<c:forEach items="${greeting.colors}" var="greetingColor">
									<c:if test="${greetingColor.id eq color.id}">
										<c:set var="found" value="true" />
									</c:if>
								</c:forEach>
								<c:choose>
									<c:when test="${found eq true}">
										<option value="${color.id}" selected>${color.colorName}</option>
									</c:when>
									<c:otherwise>
										<option value="${color.id}" >${color.colorName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Submit" />
					</td>
				</tr>
			</table>
		</form:form>
	</body>
</html>