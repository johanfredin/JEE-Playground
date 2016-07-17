<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<%=request.getContextPath()%>/style/common.css" type="text/css" rel="stylesheet" />
<style type="text/css">
</style>
<head>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<!--PENDING GIGS ---------------------------------------------------------------------------------------->
	<h2 class="underline">
		<img src="<%=request.getContextPath()%>/images/flightrequest.png">
		<spring:message code="global.contacts"/>
 	</h2>
 	
 	<p>
		<a class="button" href="<%=request.getContextPath()%>/editContactPerson/0.html"><spring:message code="index.createContact"/></a>
	</p>
	
	<table class="dataTable">
		<tr>
			<th><spring:message code="global.contact.firstName"/></th>
			<th><spring:message code="global.contact.lastName"/></th>
			<th><spring:message code="global.contact.email"/></th>
			<th><spring:message code="global.edit"/></th>
		</tr>
		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td>${contact.firstName}</td>
				<td>${contact.lastName}</td>
				<td>${contact.email}</td>
				<td><a href="<%=request.getContextPath()%>/editContactPerson/${contact.id}.html"><img src="images/edit.png" ></a></td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>