
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/view/template/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
<script type="text/javascript">

	var NotBeforeToday = function(date) {
		var now = new Date(); //this gets the current date and time
		if (date.getFullYear() == now.getFullYear()
				&& date.getMonth() == now.getMonth()
				&& date.getDate() >= now.getDate()
				&& (date.getDay() > 0 && date.getDay() < 6))
			return [ true, "" ];
		if (date.getFullYear() >= now.getFullYear()
				&& date.getMonth() > now.getMonth()
				&& (date.getDay() > 0 && date.getDay() < 6))
			return [ true, "" ];
		if (date.getFullYear() > now.getFullYear()
				&& (date.getDay() > 0 && date.getDay() < 6))
			return [ true, "" ];
		return [ false, "" ];
	}
	
	
	

	$(function() {
		
		$('#idDateField').datepicker({

			minDate : '0',
			maxDate : '10'
		});
		
		$( "#idDateField" ).change(function() {
			 var dateval = $( "#idDateField" ).val();
			 var sendData = {dateval: dateval}
			 $.ajax({
				
					//url :"/activeSlots?date="+dateval ,
					 url :"activeSlots?date=" + dateval ,
				//		method : GET,
				//	contentType: 'application/json',
					success: function (data) {
						alert(data);
						$('#idTimefield').empty();
						var times=JSON.parse(data);
						var values= Object.values(times);
						var keys = Object.keys(times);
						
						
						for(i=0 ; i<values.length;i++){
							$('#idTimefield').append('<option value="' + keys[i] + '">' + values[i] + '</option>');
						}
					
					          
					        },
					        error:function(data) {
					            alert("error:"+data.val);
					        }
					
				});
			});
		
		
		
	});
</script>

 <body> 

 <main role="main" class="container">
 
 <div class="text-center mb-4">

      <div class="starter-template">
        <h1>Make an Appointment1</h1>
        <p class="lead">The first step towards a beautiful, healthy smile is to schedule an initial appointment. Please contact our office by phone or complete the appointment request form below.</p>
      </div>

   

	<form:form class="form-signin" action="confirm" modelAttribute="appointment">

	Name : <form:input id="nameid" path="name" />
		<br><br>
	
	Phone : <form:input path="phone" />
		<br><br>

	Email : <form:input path="email" />
		<br><br>

	Date :<form:input id="idDateField" path="date"/>
		
		<br><br>

    Time : <form:select id="idTimefield" path="time">
				<form:option value="-" label="--Please Select--" />
				<form:options items="${appointment.timeSlots}" />
			</form:select>

		<br><br>
	
	

	Description : <form:textarea path="description" />
		<br><br>

		<button class="btn btn-lg btn-primary " type="submit">Request
			Appointment</button>
		
	</form:form>
</div>	

 </main>
 	
 
 </body>
 </html>

