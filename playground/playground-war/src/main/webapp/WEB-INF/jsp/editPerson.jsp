<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title><spring:message code="global.createPerson" /></title>
<link href="<%=request.getContextPath()%>/style/common.css"	type="text/css" rel="stylesheet" />

</head>
<body>

	<jsp:include page="header.jsp" />

	<h2 class="underline">
	
	<c:choose>
		<c:when test="${editPersonBean.person.id > 0}">
			<spring:message code="editPerson.title.update" />
		</c:when>
		<c:otherwise>
			<spring:message code="editPerson.title.create" />
		</c:otherwise>
	</c:choose>
	</h2>

	<form:form commandName="editPersonBean">
		<form:hidden path="person.id"/>
		<table class="formTable">
			<c:if test="${editPersonBean.person.id > 0}">
			<tr>
				<th><spring:message code="global.id" /></th>
				<td>${editPersonBean.person.id}</td>
				<td></td>
			</tr>
			</c:if>
			
			<tr>
				<th><spring:message code="global.person.firstName" /></th>
				<td><form:input path="person.firstName"/></td>
<%-- 				<td><form:errors path="customer.firstName" cssClass="errors" /></td> --%>
			</tr>
			
			<tr>
				<th><spring:message code="global.person.lastName" /></th>
				<td><form:input path="person.lastName"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="global.person.email" /></th>
				<td><form:input path="person.email"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="global.person.phone" /></th>
				<td><form:input path="person.phoneNr"/></td>
			</tr>
			
			<tr>
				<th></th>
				<td>
					<c:set var="submitText">
						<spring:message code="global.submit" />
					</c:set>
					<input type="submit" value="${submitText}"/> <a href="<%=request.getContextPath()%>/index.html"><spring:message code="global.cancel" /></a></td>
				<td></td>
			</tr>
			</table>
			</form:form>
</body>
</html>