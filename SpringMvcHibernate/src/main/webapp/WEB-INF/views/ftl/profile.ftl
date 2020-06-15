	<!-- Header -->
	<#include "header.ftl"> 

<script type = "text/javascript" >
   window.history.forward();
	function noBack() { window.history.forward(); }
</script>
	
		<main class="d-flex primary-background">
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-3">
					<div class="card reg-top">
						<!-- <div class="card-header login-bg text-white text-center">
							<br> <span class="fa fa-vcard fa-3x"></span> <br>
							<h3 class="display-5">TESTING PROFILE PAGE</h3>
						</div> -->
						<div class="card-header login-bg ">
							<h3 class="display-5 text-white text-center">PROFILE PAGE</h3>
							<div class="d-flex justify-content-center h-100">
								<div class="image_outer_container">
									<div class="green_icon"></div>
									<div class="image_inner_container">
										<img src="data:image/jpeg;base64,${userModel.base64image}" class="img-fluid">


										<!-- https://bootsnipp.com/snippets/gN2b5 -->
									</div>
								</div>
							</div>
							<h3 class="display-5 text-white text-center">
								<#-- FirstName And Last Name -->
								${userModel.fname} ${userModel.lname}
							</h3>
						</div>

						<div class="card-body text-center">

							<table class="table">
								<tbody>
									<tr>
										<th>Email</th>
										<th>:</th>
										<td>${userModel.email}</td>
									</tr>
									<tr>
										<th>Birth Date</th>
										<th>:</th>
										<td>${userModel.dob}</td>
									</tr>
									<tr>
										<th class="w-25">Mobile No</th>
										<th>:</th>
										<td>${userModel.m_no}</td>
									</tr>
									<tr>
										<th>Gender</th>
										<th>:</th>
										<td>${userModel.gender}</td>
									</tr>
									<tr>
										<th>Language</th>
										<th>:</th>
										<td>${userModel.language}</td>
									</tr>
									<tr>
										<th>Hobby</th>
										<th>:</th>
										<td>${userModel.hobbie}</td>
									</tr>

									<#assign count=1>
									<#list userModel.addressModel as Address>
									<!-- Address -->
										<tr>
											<th>Address${count} </th>
											<th>:</th>
											<td>${Address.address}</td>
										</tr>
										<tr>
											<th>City${count} </th>
											<th>:</th>
											<td>${Address.city}</td>
										</tr>
										<tr>
											<th>State${count} </th>
											<th>:</th>
											<td>${Address.state}</td>
										</tr>
										<tr>
											<th>Country${count} </th>
											<th>:</th>
											<td>${Address.country}</td>
										</tr>
									<#assign count++>
									</#list>
								</tbody>
							</table>
							<button class="btn btn-outline-light btn-lg login-bg" onclick = "preventBack()">	
							<a href="logoutuser" style="color:#FFFFFF;"><span class="fa fa-sign-out"></span>Logout</a> </button>
							
							<form method="post" class="d-inline" action = "edit">
								<input type="hidden"  name="id" value="${userModel.id}">
								<button type="submit" class="btn btn-outline-light btn-lg login-bg">
									<span class="fa fa-edit mr-1"></span>Edit
								</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	

	<!-- Footer -->
	<#include "footer.ftl">