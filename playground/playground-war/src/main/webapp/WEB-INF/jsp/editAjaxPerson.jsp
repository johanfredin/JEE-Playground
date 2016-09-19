<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title><spring:message code="global.createPerson" /></title>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js"></script>


<link href="<%=request.getContextPath()%>/style/common.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">

	$(function(){

		var source = "http://localhost:8080/playground";
		
		$("#country").on("change", function(request, response){
		    $.ajax({
		       	url: source + "/isUnique",
		      	dataType: "json",
		       	data: {
		          	term: $("#country").val()
		      	},
		       	success: function( data ) {
		       		console.log(data);
		       		console.log(response);
		       	}
		    });
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
				<th><spring:message code="global.person.firstName" /></th>
				<td><form:input path="person.firstName" id="fName" /></td>
				<td><form:errors path="person.firstName" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.person.lastName" /></th>
				<td><form:input path="person.lastName" id="lName" /></td>
				<td><form:errors path="person.lastName" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.person.email" /></th>
				<td><form:input path="person.email" id="email" /></td>
				<td><form:errors path="person.email" cssClass="errors" /></td>
				<c:choose>
					<c:when test="${isExistingEmail}">
						<td><font color="red">Email is not unique!</font></td>
					</c:when>
				</c:choose>
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
				<td><form:input path="person.address.street" id="street" /></td>
				<td><form:errors path="person.address.street" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.zipcode" /></th>
				<td><form:input path="person.address.zipCode" id="zipCode" /></td>
				<td><form:errors path="person.address.zipCode" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.city" /></th>
				<td><form:input path="person.address.city" id="city" /></td>
				<td><form:errors path="person.address.city" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.stateOrRegion" /></th>
				<td><form:input path="person.address.stateOrRegion" /></td>
				<td><form:errors path="person.address.stateOrRegion" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.country" /></th>
				<td><form:input path="person.address.country" id="country" /></td>
				<td><form:errors path="person.address.country"
						cssClass="errors" /></td>
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