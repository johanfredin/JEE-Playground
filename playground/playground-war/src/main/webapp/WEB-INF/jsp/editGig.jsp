<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title><spring:message code="index.creategig" /></title>
<link href="<%=request.getContextPath()%>/style/common.css"	type="text/css" rel="stylesheet" />

</head>
<body>

	<jsp:include page="header.jsp" />

	<h2 class="underline">
	
	<c:choose>
		<c:when test="${editGigBean.gig.id > 0}">
			<spring:message code="editGig.title.update" />
		</c:when>
		<c:otherwise>
			<spring:message code="editGig.title.create" />
		</c:otherwise>
	</c:choose>
	</h2>

	<form:form commandName="editGigBean">
		<form:hidden path="gig.id"/>
		<table class="formTable">
			<c:if test="${editGigBean.gig.id > 0}">
			<tr>
				<th><spring:message code="global.id" /></th>
				<td>${editGigBean.gig.id}</td>
				<td></td>
			</tr>
			</c:if>
			
			<tr>
				<th><spring:message code="global.venue.name" /></th>
				<td><form:input path="gig.venue.name"/></td>
<%-- 				<td><form:errors path="customer.firstName" cssClass="errors" /></td> --%>
			</tr>
			
			<tr>
				<th><spring:message code="global.gig.date" /></th>
				<td><form:input path="gig.date"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="global.gig.date" /></th>
				<td><form:input path="gig.date"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="global.venue.url" /></th>
				<td><form:input path="gig.venue.url"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="editGig.revenue" /></th>
				<td><form:input path="gig.revenue"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="editGig.travelCompensation" /></th>
				<td><form:input path="gig.isTravelCompensation"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="editGig.foodIncluded" /></th>
				<td><form:input path="gig.isFoodIncluded"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="editGig.freeBeverages" /></th>
				<td><form:input path="gig.isFreeBeverages"/></td>
			</tr>				
			
			<tr>
				<th><spring:message code="editGig.backline" /></th>
				<td><form:input path="gig.isBackline"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="editGig.backstage" /></th>
				<td><form:input path="gig.isBackStage"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="editGig.noAlcohol" /></th>
				<td><form:input path="gig.isNoAlcohol"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="global.address.street" /></th>
				<td><form:input path="gig.venue.address.street" /></td>
			</tr>
			
			<tr>
				<th><spring:message code="global.address.zipcode" /></th>
				<td><form:input path="gig.venue.address.zipCode" /></td>
			</tr>
			
			<tr>
				<th><spring:message code="global.address.stateOrRegion" /></th>
				<td><form:input path="gig.venue.address.stateOrRegion" /></td>
			</tr>
			
			<tr>
				<th><spring:message code="global.address.country" /></th>
				<td><form:input path="gig.venue.address.country" /></td>
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