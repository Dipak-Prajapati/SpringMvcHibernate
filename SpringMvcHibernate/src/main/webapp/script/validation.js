var xFile, xFirst, xLast, xEmail, xDob, xMobile, xGender, xLanguage, xHobbie, xPassword, xCPassword;

xFile = xFirst = xLast = xEmail = xDob = xMobile = xGender = xLanguage = xHobbie = xPassword = xCPassword = false;
// xAddress=

function validate() {

	var fname = document.getElementById('fname').value;
	var mname = document.getElementById('mname').value;
	var lname = document.getElementById('lname').value;
	var email = document.getElementById("email").value;
	var dob = document.getElementById("dob").value;
	var contact = document.getElementById("m_no").value;
	var password = document.getElementById("pwd").value;
	var cpassword = document.getElementById("cpwd").value;

	if (fname == "") {
		document.getElementById('sfname').innerHTML = "* Required Field!!!";
		return false;
	}
	if (fname != "") {
		document.getElementById('sfname').innerHTML = "";
	}
	if (mname == "") {
		document.getElementById('smname').innerHTML = "* Required Field!!!";
		return false;
	}
	if (mname != "") {
		document.getElementById('smname').innerHTML = "";
	}
	if (lname == "") {
		document.getElementById('slname').innerHTML = "* Required Field!!!";
		return false;
	}
	if (lname != "") {
		document.getElementById('slname').innerHTML = "";
	}
	if (email == "") {
		document.getElementById('semail').innerHTML = "* Required Field!!!";
		return false;
	}
	if (email != "") {
		document.getElementById('semail').innerHTML = "";
	}
	if (dob == "") {
		document.getElementById('sdob').innerHTML = "* Required Field!!!";
		return false;
	}
	if (dob != "") {
		document.getElementById('sdob').innerHTML = "";
	}
	if (contact == "") {
		document.getElementById('sm_no').innerHTML = "* Required Field!!!";
		return false;
	}
	if (contact != "") {
		document.getElementById('sm_no').innerHTML = "";
	}
	if (password == "") {
		document.getElementById('spwd').innerHTML = "* Required Field!!!";
		return false;
	}
	if (password != "") {
		document.getElementById('spwd').innerHTML = "";
	}
	if (cpassword == "") {
		document.getElementById('scpwd').innerHTML = "* Required Field!!!";
		return false;
	}
	if (cpassword != "") {
		document.getElementById('scpwd').innerHTML = "";
	}
}

function inputFile() {
	var file = document.getElementById("pic").files[0];
	var fileName = document.getElementById("pic").value;
	var allowed_extensions = new Array("jpg", "png", "gif", "jpeg");
	var file_extension = fileName.split('.').pop();
	var valid = false;

	if (fileName == 0) {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('spic').innerText = "* Please Select Your Profile Pic *";
		xFile = false;
	}
	for (var i = 0; i < allowed_extensions.length; i++) {
		if (allowed_extensions[i] == file_extension) {
			valid = true;

			if (file.size > 2097152) {
				document.getElementById('spic').innerText = "* Image Size Must Be Under 2mb *";
				xFile = false;
			} else {
				document.getElementById('shead').innerText = " ";
				document.getElementById('spic').innerText = " ";
				xFile = true;
			}

		}
	}
	if (valid == false) {
		document.getElementById('spic').innerText = "* Please Select The Valid Image *";
		xFile = false;
	}
	// validate();
}

function inputfname() {
	var firstname = document.getElementById("fname");
	var alphaExp = /^[a-zA-Z]+$/;

	if (firstname.value.length == 0) {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sfname').innerText = "* Enter The First Name *";
		// xFirst=false;
		xLast = false;
	} else if (firstname.value.match(alphaExp)) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('sfname').innerText = " ";
		xFirst = true;
	} else {
		document.getElementById('shead').innerText = " ";
		document.getElementById('sfname').innerText = "* For Your First Name Please Use Alphabets Only *";
		xFirst = false;
	}
	// validate();
}

function inputlname() {
	var lastname = document.getElementById("lname");
	var alphaExp = /^[a-zA-Z]+$/;

	if (lastname.value.length == 0) {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('slname').innerText = "* Enter The Last Name *";
		xLast = false;
	} else if (lastname.value.match(alphaExp)) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('slname').innerText = " ";
		xLast = true;
	} else {
		document.getElementById('slname').innerText = "* For Your Last Name Please Use Alphabets Only *";
		xLast = false;
	}
	// validate();
}

function inputemail() {
	var emailid = document.getElementById("email");
	var emailExp = /^[a-z0-9._][a-zA-Z0-9-_]+@[a-z0-9]+\.[a-z]{2,4}/;

	if (emailid.value.length == 0) {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('semail').innerText = "* Please Enter The Email *";
		xEmail = false;
	} else if (emailid.value.match(emailExp)) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('semail').innerText = " ";
		xEmail = true;
	} else {
		document.getElementById('semail').innerText = "* Please Enter a Valid Email Address *";
		xEmail = false;
	}
	// validate();
}

function inputdob() {
	var birthday = document.getElementById("dob").value;

	if (birthday.length == 10) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('sdob').innerText = " ";
		xDob = true;
	} else {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sdob').innerText = "* Enter The Valid Date Of Birth *";
		xDob = false;
	}
	// validate();
}

function inputmno() {
	var m_no = document.getElementById("m_no");
	var mobileExp = /^[0-9]{10,10}$/;

	if (m_no.value.length == 0) {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sm_no').innerText = "* Please Enter The Mobile Number *";
		xMobile = false;
	} else if (m_no.value.match(mobileExp)) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('sm_no').innerText = " ";
		xMobile = true;
	} else {
		document.getElementById('sm_no').innerText = "* Please Enter The Valid Mobile Number *";
		xMobile = false;
	}
	// validate();
}

function inputgender() {
	var genders = document.getElementsByName("gender");
	if (genders[0].checked == true) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('sgender').innerText = " ";
		xGender = true;
	} else if (genders[1].checked == true) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('sgender').innerText = " ";
		xGender = true;
	} else {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sgender').innerText = "* You Must Select Your Gender *";
		xGender = false;
	}
	// validate();
}

function inputlanguage() {
	var languages = document.getElementsByName("language");
	var check = false;

	for (var i = 0; i < languages.length; i++) {
		if (languages[i].checked) {
			check = true;
			xLanguage = true;
			break;
		}
	}
	if (check == false) {
		document.getElementById('scheck').innerText = "* Please Select Atleast One Language *";
		xLanguage = false;
	}
	// validate();
}
function inputHobbie() {
	var hobbie = document.getElementById("hobbie").value;

	if (hobbie == '') {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('shobbie').innerText = "* Please select an option! *";
		xHobbie = false;
	} else {
		document.getElementById('shead').innerText = " ";
		document.getElementById('shobbie').innerText = " ";
		xHobbie = true;
	}
	// validate();
}

function inputaddress(count) {
	var paddress = document.getElementById(count + '.address');
	if (paddress.value == "") {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('saddress' + count).innerText = "* Please Enter The Address*";
		xAddress = true;
	} else {
		document.getElementById('shead').innerText = " ";
		document.getElementById('saddress' + count).innerText = " ";
		xAddress = true;
	}
	// validate();
}
function inputcity(count) {
	var cityname = document.getElementById(count + '.city');
	var alphaExp = /^[a-zA-Z]+$/;

	if (cityname.value == "") {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('scity'+count).innerText = "* Enter The City Name *";
		xMiddle = false;
	} else if (cityname.value.match(alphaExp)) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('scity'+count).innerText = " ";
		xMiddle = true;
	} else {
		document.getElementById('shead').innerText = " ";
		document.getElementById('scity'+count).innerText = "* For Your City Name Please Use Alphabets Only *";
		xMiddle = false;
	}
	// validate();
}
function inputstate(count) {
	var statename = document.getElementById(count + '.state');
	var alphaExp = /^[a-zA-Z]+$/;

	if (statename.value == "") {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sstate'+count).innerText = "* Enter The State Name *";
		xMiddle = false;
	} else if (statename.value.match(alphaExp)) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('sstate'+count).innerText = " ";
		xMiddle = true;
	} else {
		document.getElementById('shead').innerText = " ";
		document.getElementById('sstate'+count).innerText = "* For Your State Name Please Use Alphabets Only *";
		xMiddle = false;
	}
	// validate();
}
function inputcountry(count) {
	var countryname = document.getElementById(count + '.country');
	var alphaExp = /^[a-zA-Z]+$/;

	if (countryname.value == "") {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('scountry'+count).innerText = "* Enter The Country Name *";
		xMiddle = false;
	} else if (countryname.value.match(alphaExp)) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('scountry'+count).innerText = " ";
		xMiddle = true;
	} else {
		document.getElementById('shead').innerText = " ";
		document.getElementById('scountry'+count).innerText = "* For Your Country Name Please Use Alphabets Only *";
		xMiddle = false;
	}
	// validate();
}

function inputpassword() { /* "^([a-zA-Z0-9@*#]{8,15})$" */
	var pwdExp = /^[a-zA-Z0-9]{8,16}$/;
	var password1 = document.getElementById("pwd");
	if (password1.value == '') {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('spwd').innerText = "* Please Enter The Password *";
		xPassword = false;
	} else if (password1.value.match(pwdExp)) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('spwd').innerText = " ";
		xPassword = true;
	} else {
		document.getElementById('shead').innerText = " ";
		document.getElementById('spwd').innerText = "* Password Not In Range *";
		xPassword = false;
	}
	// validate();
}

function inputcpassword() {
	var password1 = document.getElementById("pwd");
	var confirm_password = document.getElementById("cpwd");

	if (confirm_password.value == '') {
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('scpwd').innerText = "* Please Enter The Confirm Password *";
		xCPassword = false;
	} else if (password1.value != confirm_password.value) {
		document.getElementById('shead').innerText = " ";
		document.getElementById('spwd').innerText = " ";
		document.getElementById('scpwd').innerText = "* Password Did Not Match...Please Try Again :( *";
		xCPassword = false;
	} else {
		document.getElementById('shead').innerText = " ";
		document.getElementById('scpwd').innerText = " ";
		xCPassword = true;
	}
	// validate();
}

function resetFile() {
	document.getElementById('spic').innerText = " ";
}
function resetFirstName() {
	document.getElementById('sfname').innerText = " ";
}
function resetLastName() {
	document.getElementById('slname').innerText = " ";
}
function resetEmail() {
	document.getElementById('semail').innerText = " ";
}
function resetDob() {
	document.getElementById('sdob').innerText = " ";
}
function resetMno() {
	document.getElementById('sm_no').innerText = " ";
}
function resetGender() {
	document.getElementById('sgender').innerText = " ";
}
function resetLanguage() {
	document.getElementById('scheck').innerText = " ";
}
function resetHobbie() {
	document.getElementById('shobbie').innerText = " ";
}
function resetAddress(count) {
	document.getElementById('saddress'+count).innerText = " ";
}
function resetCity(count) {
	document.getElementById('scity'+count).innerText = " ";
}
function resetState(count) {
	document.getElementById('sstate'+count).innerText = " ";
}
function resetCountry(count) {
	document.getElementById('scountry'+count).innerText = " ";
}
function resetPassword() {
	document.getElementById('spwd').innerText = " ";
}
function resetConfirmPassword() {
	document.getElementById('scpwd').innerText = " ";
}
