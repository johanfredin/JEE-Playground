<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title><spring:message code="global.createPerson" /></title>

<script src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=places&key=AIzaSyDtwepldqpFwcN9nq6gpdEjyPRrhxDshkw"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/geolocate.js"></script>

<style type="text/css" media="screen">
      .map_canvas { float: left; }
      form { width: 300px; float: left; }
      fieldset { width: 320px; margin-top: 20px}
      fieldset label { display: block; margin: 0.5em 0 0em; }
      fieldset input { width: 95%; }
    </style>

<link href="<%=request.getContextPath()%>/style/common.css" type="text/css" rel="stylesheet" />

<script>
      $(function(){

		// Start by retrieving the data from DB (if any)
// 		$("#gmapStreet").val($("#street").val());
// 		$("#gmapZipCode").val($("#zipCode").val());
// 		$("#gmapCity").val($("#city").val());
// 		$("#gmapStateOrRegion").val($("#stateOrRegion").val());
// 		$("#gmapCountry").val($("#country").val());

        $("#geocomplete").geocomplete({
          map: ".map_canvas",
          details: "maForm",
          types: ["geocode", "establishment"],
        });

        $("#find").click(function(){
          $("#geocomplete").trigger("geocode");
        });

		// Takes in all values from google map autocomplete and transfers to our JPA entity
//         $("#submitButton").on("click", function(){
// 			$("#street").val($("#gmapStreet").val());
// 			$("#zipCode").val($("#gmapZipCode").val());
// 			$("#city").val($("#gmapCity").val());
// 			$("#stateOrRegion").val($("#gmapStateOrRegion").val());
// 			$("#country").val($("#gmapCountry").val());
//       		alert("its so easy baby!");  
//         });
        
      });
</script>

</head>
<body>

	<jsp:include page="header.jsp" />
	
	<input id="geocomplete" type="text" placeholder="Find a venue" value="" />
    <input id="find" type="button" value="find" />
	
	<h2 class="underline"> 	

		<c:choose>
			<c:when test="${editAddressBean.address.id > 0}">
				Update Address
			</c:when>
			<c:otherwise>
				Create Address
			</c:otherwise>
		</c:choose>
	</h2>
	<form:form modelAttribute="editAddressBean" id="maForm">
		<form:hidden path="address.id" />
		<table class="formTable">

			<!-------------------------------------------------------------------------------------------------->
			<!------------------------------ ADDRESS ----------------------------------------------------------->
			<!-------------------------------------------------------------------------------------------------->
			
			<tr>
				<th><spring:message code="global.address.street" /></th>
				<td><form:input path="address.street" name="route" id="street" /></td>
				<td><form:errors path="address.street" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.zipcode" /></th>
				<td><form:input path="address.zipCode" name="postal_code" id="zipCode" /></td>
				<td><form:errors path="address.zipCode" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.city" /></th>
				<td><form:input path="address.city" name="locality" id="city" /></td>
				<td><form:errors path="address.city" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.stateOrRegion" /></th>
				<td><form:input path="address.stateOrRegion" name="administrative_area_level_1" id="stateOrRegion" /></td>
				<td><form:errors path="address.stateOrRegion" cssClass="errors" /></td>
			</tr>

			<tr>
				<th><spring:message code="global.address.country" /></th>
				<td><form:input path="address.country" name="country" id="country"/></td>
				<td><form:errors path="address.country" cssClass="errors" /></td>
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
					
					<input type="submit" id="submitButton" value="${submitText}"/>
					<a href="<%=request.getContextPath()%>/index.html">
					<spring:message code="global.cancel" /></a></td>
				<td></td>
			</tr>
		</table>
	</form:form>

	<div class="map_canvas"></div>


</body>
</html>