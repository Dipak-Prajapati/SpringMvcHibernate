	<!-- Header -->
	<#include "header.ftl"> 
	
	<script type = "text/javascript" >
	   function preventBack(){window.history.forward();}
	    setTimeout("preventBack()", 0);
	    window.onunload=function(){null};
	</script>
	<main
	class="d-flex align-items-center login-height primary-background banner-background">
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header login-bg text-white text-center">
						<span class="fa fa-user-circle fa-spin fa-3x"></span> <br>
						<p>Login Here</p>
					</div>
						
				<#--  	<div class="alert alert-danger mb-0 " role="alert">
						<strong>${message!""}</strong>
					</div> -->
					
					<#-- UserName or Password is wrong msg -->
					<strong class="text-center mt-2" style="color: #a94442;background-color: #f2dede;border-color: #ebccd1;border-radius: 13px;">${message!""}</strong>

					<#-- Logout SuccessFully Message -->
					<strong class="text-center mt-2" style="color: #155724;background-color: #d4edda;border-color: #c3e6cb;border-radius: 13px;">${logoutmessage!""}</strong>
					<div class="card-body">
						<form action="logincheck" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="email" name="email"
									aria-describedby="emailHelp" placeholder="Enter email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="pwd" name="pwd"
									placeholder="Password">
							</div>

							<button type="submit"
								class="btn btn-outline-light btn-lg login-btn-width login-bg">Login</button>
							
							<div class="text-center mt-2 font-weight-bold">
								<a href="forgotPassword">Forgot Password ?</a> 
							</div>
							<div class="text-center mt-1 font-weight-bold">
								<span class="text-secondary">NO ACCOUNT ?</span> <a href="registration">SignUp</a> 
							</div>
									
								
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
	
	
	<!-- Footer -->
	<#include "footer.ftl">