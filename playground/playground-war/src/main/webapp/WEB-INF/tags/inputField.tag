<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ attribute name="name" required="true" rtexprvalue="true"%>
<%@ attribute name="label" required="true" rtexprvalue="true"%>
<%@ attribute name="id" required="false" rtexprvalue="true"%>
<div id="${id}">
	<label><spring:message code="${label}"></spring:message></label>
	<div>
		<form:input path="${name}" id="${id}" />
		<span><form:errors path="${name}" cssClass="errors"/></span>
	</div>
</div>