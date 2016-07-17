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
		<spring:message code="global.confirmedgigs"/>
 	</h2>
 	
 	<p>
		<a class="button" href="<%=request.getContextPath()%>/editGig/0.html"><spring:message code="index.creategig"/></a>
	</p>
	
	<table class="dataTable">
		<tr>
			<th><spring:message code="global.gig.date"/></th>
			<th><spring:message code="global.venue.name"/></th>
			<th><spring:message code="global.edit"/></th>
		</tr>
		<c:forEach items="${gigs}" var="gig">
			<tr>
				<td>${gig.date}</td>
				<td>${gig.venue.name}</td>
				<td><a href="<%=request.getContextPath()%>/editGig/${gig.id}.html"><img src="images/edit.png" ></a></td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>