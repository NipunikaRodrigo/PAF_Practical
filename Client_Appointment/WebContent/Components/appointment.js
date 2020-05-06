$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertSuccess").hide();

});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------

	var type = ($("#hidAIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "AppointmentAPI",
		type : type,
		data : $("#formAppointment").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onAppSaveComplete(response.responseText, status);
		}
	});
});

function onAppSaveComplete(response, status) {
	
	
	if (status == "success") {
		var resultSet = JSON.parse(response);

    if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divAppointmentsGrid").html(resultSet.data);

		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}

	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();

		
	} 

	else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	
	$("#hidAIDSave").val("");
	$("#formAppointment")[0].reset();
}

// UPDATE==========================================
$(document).on(
		"click",
		".btnUpdate",
		function(event) {
			$("#hidAIDSave").val(
					$(this).closest("tr").find('#hidAIDUpdate').val());
			$("#PID").val($(this).closest("tr").find('td:eq(1)').text());
			$("#PName").val($(this).closest("tr").find('td:eq(2)').text());
			$("#Gender").val($(this).closest("tr").find('td:eq(3)').text());
			$("#DName").val($(this).closest("tr").find('td:eq(4)').text());
			$("#RoomNo").val($(this).closest("tr").find('td:eq(5)').text());
			$("#Date").val($(this).closest("tr").find('td:eq(6)').text());
			$("#Time").val($(this).closest("tr").find('td:eq(7)').text());
			$("#HName").val($(this).closest("tr").find('td:eq(8)').text());
			
			
		});

// REMOVE==========================================
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "AppointmentAPI",
		type : "DELETE",
		data : "AID=" + $(this).data("aid"),
		dataType : "text",
		complete : function(response, status) {
			onAppDeleteComplete(response.responseText, status);
		}
	});
});

function onAppDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divAppointmentsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}



// CLIENTMODEL=========================================================================

function validateForm() {
	
	if ($("#PID").val().trim() == "") {
		return "Insert PatientID.";
	}
	
	if ($("#PName").val().trim() == "") {
		return "Insert Patient name.";
	}
	if ($("#Gender").val().trim() == "") {
		return "Insert Gender .";
	}
	

	
	if ($("#DName").val().trim() == "") {
		return "Insert a Doctor name.";
	}
	
	
	if ($("#RoomNo").val().trim() == "") {
		return "Insert a Room number.";
	}
	
	
	if ($("#Date").val().trim() == "") {
		return "Insert a  Date.";
	}
	
	
	if ($("#Date").val().trim() == "") {
		return "Insert a Doctor ID .";
	}
	
	
	if ($("#Time").val().trim() == "") {
		return "Insert Time .";
	}
	
	
	if ($("#HName").val().trim() == "") {
		return "Insert a Hospital .";
	}
	
	

	return true;
}


