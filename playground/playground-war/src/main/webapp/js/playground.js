/**
 * 
 */
var source = "http://localhost:8080/playground";

$(document).ready(function() {
		$("#fName").autocomplete({
			source: function(request, response) {
		    	console.log(request);
		    	console.log(response);
				$.ajax({
		        	url: source + "/getMatchingFirstName",
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
		   }
		});
		
		$("#fName").on("mouseenter", function(){
			$("#fName").css("background-color", "grey");
		}).on("mouseleave", function(){
			$("#fName").css("background-color", "white");
		});
	});