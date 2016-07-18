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
		<spring:message code="global.persons"/>
 	</h2>
 	
 	<p>
		<a class="button" href="<%=request.getContextPath()%>/editPerson/0.html"><spring:message code="global.createPerson"/></a>
	</p>
	
	<table class="dataTable">
		<tr>
			<th><spring:message code="global.person.firstName"/></th>
			<th><spring:message code="global.person.lastName"/></th>
			<th><spring:message code="global.person.email"/></th>
			<th><spring:message code="global.edit"/></th>
		</tr>
		<c:forEach items="${persons}" var="person">
			<tr>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.email}</td>
				<td><a href="<%=request.getContextPath()%>/editPerson/${person.id}.html"><img src="images/edit.png" ></a></td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>