<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title><spring:message code="global.createPerson" /></title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.1.0.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>

<link href="<%=request.getContextPath()%>/style/common.css"
	type="text/css" rel="stylesheet" />

<link href="<%=request.getContextPath()%>/style/jquery-ui.css"
	type="text/css" rel="stylesheet" />

<script type="text/javascript">

	$(document).ready(function() {
		$("#fName").autocomplete({
			source: function(request, response) {
		    	$.ajax({
		        	url: "<%=request.getContextPath()%>/getMatchingFirstName",
		          	dataType: "json",
		          	data: {
		            	term: request.term
		          	},
		          	success: function( data ) {
		          		console.log("REQUEST=" + request + " successful!");
		            	person = response($.map(data, function(item) {
		 	                return {
		 	                    label: item.firstName + " (" + item.email + ")", 	// The label selection being shown
		 	                    value: item.firstName,								// The value to be added to the text field
								pet: item.pet,
								address: item.address,
				 	        }
		 	            }));
		          	}
		        });
		   },
		   minLength: 2,
		   select: function(event, item) {
			   $("#lName").val(item.item.lastName);
			   $("#email").val(item.item.email);
			   $("#phone").val(item.item.phone);
			   $("#country").val(item.item.address.country);
			   $("#petName").val(item.item.pet.name);
		   }
		});		
	});
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
		<form:hidden path="person.id" />
		<table class="formTable">

			<!------------------------------------------------------------------------------------------------------>
			<!------------------------------ PERSON ---------------------------------------------------------------->
			<!------------------------------------------------------------------------------------------------------>

			<tr>
				<th><label for="fName"><spring:message code="global.person.firstName" /></label></th>
				<td><form:input path="person.firstName" id="fName" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.person.lastName" /></th>
				<td><form:input path="person.lastName" id="lName" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.person.email" /></th>
				<td><form:input path="person.email" id="email"/></td>
				<td><form:errors path="person.email" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.person.phone" /></th>
				<td><form:input path="person.phoneNr" id="phone" /></td>
				<td><form:errors path="person.phoneNr" cssClass="errors" /></td>
			</tr>

			<!-------------------------------------------------------------------------------------------------->
			<!------------------------------ ADDRESS ----------------------------------------------------------->
			<!-------------------------------------------------------------------------------------------------->

			<tr>
				<th><spring:message code="global.address.street" /></th>
				<td><form:input path="person.address.street" /></td>
				<td><form:errors path="person.address.street" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.zipcode" /></th>
				<td><form:input path="person.address.zipCode" /></td>
				<td><form:errors path="person.address.zipCode"
						cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.city" /></th>
				<td><form:input path="person.address.city" /></td>
				<td><form:errors path="person.address.city" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.stateOrRegion" /></th>
				<td><form:input path="person.address.stateOrRegion" /></td>
				<td><form:errors path="person.address.stateOrRegion"
						cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.country" /></th>
				<td><form:input path="person.address.country" id="country" /></td>
				<td><form:errors path="person.address.country"
						cssClass="errors" /></td>
			</tr>
			<!-------------------------------------------------------------------------------------------------->
			<!------------------------------ PET --------------------------------------------------------------->
			<!-------------------------------------------------------------------------------------------------->

			<tr>
				<th><spring:message code="global.pet.name" /></th>
				<td><form:input path="person.pet.name" id="petName" /></td>
				<td><form:errors path="person.pet.name" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.pet.type" /></th>
				<td><form:select path="person.pet.type">
						<form:options />
					</form:select></td>
				<td><form:errors path="person.pet.type" cssClass="errors" /></td>
			</tr>

			<!------------------------------------------------------------------------------------------------------>
			<!------------------------------ END ------------------------------------------------------------------->
			<!------------------------------------------------------------------------------------------------------>

			<tr>
				<th></th>
				<td><c:set var="submitText">
						<spring:message code="global.submit" />
					</c:set> <input type="submit" value="${submitText}" /> <a
					href="<%=request.getContextPath()%>/index.html"><spring:message
							code="global.cancel" /></a></td>
				<td></td>
			</tr>
		</table>
	</form:form>

</body>
</html>