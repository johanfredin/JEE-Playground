<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="customWithChoise" tagdir="/WEB-INF/tags"%>
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

			<!------------------------------------------------------------------------------------------------------>
			<!------------------------------ PERSON ---------------------------------------------------------------->
			<!------------------------------------------------------------------------------------------------------>
			
			<custom:inputField label="global.person.firstName" name="person.firstName" id="fName"/>	
			<custom:inputField label="global.person.lastName" name="person.lastName" id="lName"/>	
			<custom:inputChoiseTag label="global.person.email" name="person.email" id="email" conditionViolated="${isExistingEmail}" errorMessage="Email is not unique!" />
			<custom:inputField label="global.person.phone" name="person.phoneNr" id="phone"/>

			<!-------------------------------------------------------------------------------------------------->
			<!------------------------------ ADDRESS ----------------------------------------------------------->
			<!-------------------------------------------------------------------------------------------------->

			<custom:inputField label="global.address.street" name="person.address.street" id="street"/>
			<custom:inputField label="global.address.zipcode" name="person.address.zipCode" id="zipCode"/>
			<custom:inputField label="global.address.city" name="person.address.city" id="city"/>
			<custom:inputField label="global.address.stateOrRegion" name="person.address.stateOrRegion"/>
			<custom:inputField label="global.address.country" name="person.address.country" id="country"/>

			<!------------------------------------------------------------------------------------------------------>
			<!------------------------------ END ------------------------------------------------------------------->
			<!------------------------------------------------------------------------------------------------------>

				<th></th>
				<td><c:set var="submitText">
						<spring:message code="global.submit" />
					</c:set> <input type="submit" value="${submitText}" /> <a
					href="<%=request.getContextPath()%>/index.html"><spring:message
							code="global.cancel" /></a></td>
				<td></td>
	</form:form>





</body>
</html>