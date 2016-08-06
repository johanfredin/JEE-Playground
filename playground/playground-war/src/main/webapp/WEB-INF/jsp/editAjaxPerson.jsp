<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title><spring:message code="global.createPerson" /></title>
<link href="<%=request.getContextPath()%>/style/common.css"	type="text/css" rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	
<script type="text/javascript">

	function doSearch() {
 		$.getJSON(
 			"<%=request.getContextPath()%>" + "/getMatchingFirstName", 
 			{ FIRST_NAMES : $('#searchBox').val()}, 

			function(data) {

				// Clear the div first
				$("#results").text("");

				for(var index in data) {
					$("#results").append(data[index]);	
				}
				
			}
 		);	
	}
		
		
	
</script>

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
			
			<!------------------------------------------------------------------------------------------------------>
			<!------------------------------ PERSON ---------------------------------------------------------------->
			<!------------------------------------------------------------------------------------------------------>
			
			<tr>
				<th><spring:message code="global.person.firstName"/></th>
				<td><form:input path="person.firstName" onkeyup="doSearch()" id="searchBox"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="global.person.lastName" /></th>
				<td><form:input path="person.lastName"/></td>
			</tr>
			
			<tr>
				<th><spring:message code="global.person.email" /></th>
				<td><form:input path="person.email"/></td>
				<td><form:errors path="person.email" cssClass="errors" /></td> 
			</tr>
			
			<tr>
				<th><spring:message code="global.person.phone" /></th>
				<td><form:input path="person.phoneNr"/></td>
				<td><form:errors path="person.phoneNr" cssClass="errors" /></td> 
			</tr>
			
				<!-------------------------------------------------------------------------------------------------->
				<!------------------------------ ADDRESS ----------------------------------------------------------->
				<!-------------------------------------------------------------------------------------------------->
				
				<tr>
					<th><spring:message code="global.address.street" /></th>
					<td><form:input path="person.address.street"/></td>
					<td><form:errors path="person.address.street" cssClass="errors" /></td> 
				</tr>
				
				<tr>
					<th><spring:message code="global.address.zipcode" /></th>
					<td><form:input path="person.address.zipCode"/></td>
					<td><form:errors path="person.address.zipCode" cssClass="errors" /></td> 
				</tr>
				
				<tr>
					<th><spring:message code="global.address.city" /></th>
					<td><form:input path="person.address.city"/></td>
					<td><form:errors path="person.address.city" cssClass="errors" /></td> 
				</tr>
				
				<tr>
					<th><spring:message code="global.address.stateOrRegion" /></th>
					<td><form:input path="person.address.stateOrRegion"/></td>
					<td><form:errors path="person.address.stateOrRegion" cssClass="errors" /></td> 
				</tr>
				
				<tr>
					<th><spring:message code="global.address.country" /></th>
					<td><form:input path="person.address.country"/></td>
					<td><form:errors path="person.address.country" cssClass="errors" /></td> 
				</tr>
				
				<!-------------------------------------------------------------------------------------------------->
				<!------------------------------ PET --------------------------------------------------------------->
				<!-------------------------------------------------------------------------------------------------->
				
				<tr>
					<th><spring:message code="global.pet.name" /></th>
					<td><form:input path="person.pet.name"/></td>
					<td><form:errors path="person.pet.name" cssClass="errors" /></td> 
				</tr>
				
				<tr>
					<th><spring:message code="global.pet.type" /></th>
					<td>
						<form:select path="person.pet.type">
							<form:options/>	
						</form:select>
					</td>
					<td><form:errors path="person.pet.type" cssClass="errors" /></td> 
				</tr>
				
			<!------------------------------------------------------------------------------------------------------>
			<!------------------------------ END ------------------------------------------------------------------->
			<!------------------------------------------------------------------------------------------------------>
			
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
			
			<div id="results">
				Results will appear here...
			</div>
</body>
</html>