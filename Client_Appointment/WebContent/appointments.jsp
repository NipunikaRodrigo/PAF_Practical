<%@page import="com.Appointments"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointments Management</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/appointment.js"></script>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Appointments Management</h1>

				<form id="formAppointment" name="formAppointment">
					Patient ID: <input id="PID" name="PID" type="text"
						class="form-control form-control-sm"> <br> Patient
					Name: <input id="PName" name="PName" type="text"
						class="form-control form-control-sm"> <br> Gender: <input
						id="Gender" name="Gender" type="text"
						class="form-control form-control-sm"> <br> Doctor
					Name: <input id="DName" name="DName" type="text"
						class="form-control form-control-sm"> <br> Room
					Number: <input id="RoomNo" name="RoomNo" type="text"
						class="form-control form-control-sm"> <br> Date: <input
						id="Date" name="Date" type="text"
						class="form-control form-control-sm"> <br> Time: <input
						id="Time" name="Time" type="text"
						class="form-control form-control-sm"> <br> Hospital
					Name: <input id="HName" name="HName" type="text"
						class="form-control form-control-sm"> <br> <input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidAIDSave" name="hidAIDSave" value="">
				</form>


				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divAppointmentsGrid">
					<%
						Appointments appObj = new Appointments();
						out.print(appObj.readAppointments());
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>