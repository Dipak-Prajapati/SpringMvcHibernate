	<!-- Header -->
	<#include "header.ftl"> 
<script type = "text/javascript" >
	function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
	
		<div class="app-body">
		<!-- Main content -->
		<main class="main">

			<div class="container-fluid m-0 p-0">
				<!-- <div class="animated fadeIn"> -->
				<div class="card">
					<div class="card-header p-0 m-0 admin-card-header">
						<div
							class="jumbotron primary-background text-white banner-background">
							<div class="container text-center mt-5 mb-5">
								<h3 class="display-3 mt-5">Welcome To Admin Panel</h3>
								<a href="logoutuser"
									class="btn btn-outline-light btn-lg mt-5 mb-5 btn-width"> <span
									class="fa fa-sign-out mr-2"></span>Logout
								</a>
							</div>
						</div>
						<!-- <p class="display-3 mt-5">Welcome To AdminPanel</p>
									<a class="btn btn-outline-light btn-lg login-bg"
										href="LogoutController"><span class="fa fa-sign-out"></span>Logout</a> -->
					</div>

					<div class="card-body">
						<!-- Table  -->
						<div class="row">
							<div class="col-lg-12">

								<table id="adminDataTable"
									class="table table-striped table-bordered" style="width: 100%">
									<thead>
										<tr>
											<th>UserId</th>
											<th>FirstName</th>
											<th>Email</th>
											<th>Date Of Birth</th>
											<th>Mobile No</th>
											<th>Gender</th>
											<th>Language</th>
											<th>ProfilePic</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<#list userModel as userModel>
											<tr class="text-center">
												<td class="align-middle">${userModel.id}</td>
												<td class="align-middle">${userModel.fname}</td>
												<td class="align-middle">${userModel.email}</td>
												<td class="align-middle">${userModel.dob}</td>
												<td class="align-middle">${userModel.m_no}</td>
												<td class="align-middle">${userModel.gender}</td>
												<td class="align-middle">${userModel.language}</td>
												<td class="align-middle"><div
														class="admin_image_outer_container">
														<div class="admin_image_inner_container">
															<img src="data:image/png;base64,${userModel.base64image}" class="img-fluid">
														</div>
													</div></td>
												<td class="align-middle">
												<form method="post" class="d-inline" action = "edit">
													<input type="hidden"  name="id" value="${userModel.id}">
													<button type="submit" class="btn btn-outline-light login-bg">
														<span class="fa fa-edit mr-1"></span>Edit
													</button>
												</form>
												</td>
												
												<td class="align-middle"><button id="deleteButton" value="${userModel.id}"
													class="btn btn-outline-light btn-danger"><span
														class="fa fa-trash mr-1"></span>Delete</button></td>
											</tr>
										</#list>
									</tbody>
									<tfoot>
										<tr>
											<th>UserId</th>
											<th>FirstName</th>
											<th>Email</th>
											<th>Date Of Birth</th>
											<th>Mobile No</th>
											<th>Gender</th>
											<th>Language</th>
											<th>ProfilePic</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</tfoot>
								</table>

							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
	
	
	<!-- Footer -->
	<#include "footer.ftl">