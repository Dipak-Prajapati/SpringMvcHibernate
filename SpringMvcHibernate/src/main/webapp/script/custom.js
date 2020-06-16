/**
 * 
 */
/*Forgot Password */

$("#forgotPassword").click(function(event) {
	event.preventDefault();
//	alert("hi");
	$.ajax({
		url : "GetPassword",
		type : "POST",
		data : {
			operation : "forgotPassword",
			email : $("#email").val()
		},
		success : function(data) {
	//		alert("........");
			$('#password').addClass('alert alert-success font-weight-bold mt-2 mb-0');
			$('#password').text(data);
		},
		error : function(data) {
			$('#password').addClass('alert alert-danger font-weight-bold mt-2 mb-0');
			$('#password').text("ERROR...!!");
		}
	});
	return false;
});



//Delete user from admin
//'#deleteButton'
$("[id^=delete]").click(function() {
	alert("Delete Button Clicked");
	var userId = $(this).val();

	var dataTable = $('#adminDataTable').DataTable();
	dataTable.row($(this).closest("tr")).remove();
	$(this).closest("tr").remove();

	$.ajax({
		url : "DeleteUser"+userId,
		type : "DELETE",
		
		success : function(data) {
			var dataTable = $('#adminDataTable').DataTable();
			dataTable.draw();
		},
		error : function(data) {
			alert("error");
		}
	});
});


$("#email").blur(function() {
	
	
	var userId = $("#userId").val();
	var email = $(this).val();

	if(email == "") {
		return false;
	}
	else {
	
	if(userId == null){
		userId = 0;
	}

	$.ajax({
		type :"POST",
		url : "emailexist",
		data : {
			email : $('#email').val() ,userId : userId
		},
		success : function(responseText) {
			
			$('#emailExistOrNot').text(responseText);
		}
	});
	
	}
});
