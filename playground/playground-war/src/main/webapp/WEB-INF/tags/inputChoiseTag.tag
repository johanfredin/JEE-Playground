<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ attribute name="name" required="true" rtexprvalue="true"%>
<%@ attribute name="label" required="true" rtexprvalue="true"%>
<%@ attribute name="id" required="false" rtexprvalue="true"%>
<%@ attribute name="conditionViolated" required="true" rtexprvalue="true"%>
<%@ attribute name="errorMessage" required="true" rtexprvalue="true"%>
<div id="${id}">
	<label><spring:message code="${label}"></spring:message></label>
	<div>
		<form:input path="${name}" id="${id}" />
		<span><form:errors path="${name}" /></span>
		<c:choose>
			<c:when test="${conditionViolated}">
				<label><font color="red">"${errorMessage}"</font></label>
			</c:when>
		</c:choose>
	</div>
</div>