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

</style>

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
		            	person = response($.map(data, function(person) {
		 	                return {
		 	                    label: person.firstName + " (" + person.email + ")", 	// The label selection being shown
		 	                    value: person.firstName,								// The value to be added to the text field
								firstName : person.firstName,
								lastName: person.lastName,
								email: person.email,
								phone: person.phoneNr,
								pet: person.pet,
								address: person.address,
				 	        }
		 	            }));
		          	}
		        });
		   },
		   minLength: 2,
		   select: function(event, ui) {
		   		console.log("Response item="); console.log(ui.item); // Log result
		   		$("#fName").css("background-color", "yellow");
			    $("#lName").val(ui.item.lastName).css("background-color", "yellow");   
			    $("#email").val(ui.item.email).css("background-color", "yellow");
			    $("#phone").val(ui.item.phone).css("background-color", "yellow");
			    $("#country").val(ui.item.address.country).css("background-color", "yellow");
			    $("#petName").val(ui.item.pet.name).css("background-color", "yellow");
		   }
		});
		
		$("#fName").on("mouseenter", function(){
			$("#fName").css("background-color", "grey");
		}).on("mouseleave", function(){
			$("#fName").css("background-color", "white");
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
				<td><form:input path="person.address.street" id="street"/></td>
				<td><form:errors path="person.address.street" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.zipcode" /></th>
				<td><form:input path="person.address.zipCode" id="zipCode" /></td>
				<td><form:errors path="person.address.zipCode"
						cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.city" /></th>
				<td><form:input path="person.address.city" id="city"/></td>
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