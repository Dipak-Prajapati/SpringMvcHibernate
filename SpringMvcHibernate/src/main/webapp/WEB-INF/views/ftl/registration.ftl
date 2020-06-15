	<!-- Header -->
	<#include "header.ftl"> 
	
	
	<main class="d-flex primary-background">
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-3">
				<div class="card reg-top">
					<div class="card-header login-bg text-white text-center">
						<br> <span class="fa fa-user-plus fa-3x"></span><br>
						<p>
						<#if userModel??>
							Update User Profile
						<#else>
							Registration Here
						</#if>
						</p>
					</div>
					<div class="card-body">

						<form name="reg" id="reg" method="post" action="<#if userModel??>update<#else>save</#if>" enctype="multipart/form-data">
							
							<span class="error" id="shead"></span>

							<div class="form-group">
								<label for="fname">First Name : </label> <input type="text"
									class="form-control" name="fname" id="fname"
									value="<#if userModel??>${userModel.fname!""}</#if>"
									placeholder="Enter Your First Name" onblur="inputfname()"
									onfocus="resetFirstName()"><br> <span
									class="error" id="sfname"></span>
							</div>

							<div class="form-group">
								<label for="lname">Last Name : </label> <input type="text"
									class="form-control" name="lname" id="lname"
									value="${(userModel.lname) !""}"
									placeholder="Enter Your Last Name" onblur="inputlname()"
									onfocus="resetLastName()"><br> <span class="error"
									id="slname"></span>
							</div>

							<div class="form-group">
								<label for="email">Email Id : </label> <input type="text"
									class="form-control" name="email" id="email"
									value="${(userModel.email) !""}"
									placeholder="Enter Your Email" onblur="inputemail()"
									onfocus="resetEmail()"><br> <span class="error"
									id="semail"></span>
							</div>
							<div class="form-group">
								<label for="dob">Date Of Birth : </label> <input type="date"
									class="form-control" name="dob" id="dob" onblur="inputdob()"
									onfocus="resetDob()"
									value="${(userModel.dob) !""}">
								<br> <span class="error" id="sdob"></span>
							</div>

							<div class="form-group">
								<label for="m_no">Mobile No : </label> <input type="text"
									class="form-control" name="m_no" id="m_no" maxlength="10"
									value="${(userModel.m_no) !""}"
									placeholder="Enter Your Mobile Number" onblur="inputmno()"
									onfocus="resetMno()"><br> <span class="error"
									id="sm_no"></span>
							</div>

							<#assign gender = (userModel.gender)!"">
							<div class="check">
								<div class="form-check form-check-inline">
									<label for="gender">Gender : </label>
									<div class="space">
										<input type="radio" class="form-check-input" name="gender"
											value="male" <#if gender == "male">checked</#if> onblur="inputgender()" onfocus="resetGender()"><label
											for="form-check-label">: Male</label>
									</div>
								</div>
								<div class="form-check form-check-inline">
									<div class="space">
										<input type="radio" class="form-check-input" name="gender"
											value="female" <#if gender == "female">checked</#if> onblur="inputgender()" onfocus="resetGender()"><label
											for="form-check-label">: Female</label>
									</div>
								</div>
								<br> <span class="error" id="sgender"></span>
							</div>

							<#assign language = (userModel.language)!"">
							<div class="check mb-4 mt-5">
								<div class="form-check form-check-inline">
									<label for="lang">Languages : </label>
									<div class="space">
										<input type="checkbox" class="form-check-input"
											name="language" <#if language?contains("gujarati")>checked</#if> value="gujarati" 
											onblur="inputlanguage()" onfocus="resetLanguage()"> <label
											for="form-check-label">: Gujarati </label>
									</div>
								</div>
								<div class="form-check form-check-inline">
									<div class="space">
										<input type="checkbox" class="form-check-input"
											name="language" <#if language?contains("hindi")>checked</#if> value="hindi"
											onblur="inputlanguage()" onfocus="resetLanguage()"> <label
											for="form-check-label">: Hindi</label>
									</div>
								</div>
								<div class="form-check form-check-inline">
									<div class="space">
										<input type="checkbox" class="form-check-input"
											name="language" <#if language?contains("english")>checked</#if> value="english" 
											onblur="inputlanguage()" onfocus="resetLanguage()"> <label
											for="form-check-label">: Enghlish </label>
									</div>
								</div>
								<br> <span class="error" id="scheck"></span>
							</div>

							<#assign hobbie = (userModel.hobbie) !"">
							<div class="form-group">
								<label for="hobbie">Hobbies : </label> <select name="hobbie"
									class="form-control" id="hobbie" onblur="inputHobbie()"
									onfocus="resetHobbie()">
									<optgroup label="Game">
										<option value="CSGO" <#if hobbie == "CSGO">selected</#if>>CSGO</option>
										<option value="PUBG" <#if hobbie == "PUBG">selected</#if>>PUBG</option>
									</optgroup>
									<optgroup label="Movie">
										<option value="Bollywood" <#if hobbie == "Bollywood">selected</#if>>Bollywood</option>
										<option value="Hollywood" <#if hobbie == "Hollywood">selected</#if>>Hollywood</option>
									</optgroup>
								</select><br> <span class="error" id="shobbie"></span>
							</div>


					<#if userModel?has_content>
					
						<div id="example1" class="form-group">	
						<#-- add button -->
						<div id="repeater" class="text-center">
								<button type="button" id="rbtn" class="btn btn-success list-add"> 
									<span class="fa fa-plus-circle" style="font-size: 30px;"></span>
								</button>
						</div>
						
						<#assign count=1>
						<#list userModel.addressModel as addressData>											
							<div class="list-item">
								<div class="form-group" id="addressrow">
									<label class="col-form-label text-md-left" for="text-input">Address${count}</label>
										<input type="text"  name="addressmodel[${addressData?index}].address" id= "${addressData?index}.address"
										class="form-control" placeholder="Address" value="${addressData.address}"
										 onblur="streetValidate(id)" required/>
										<br/> 
										 
								<div class="row">
									<div class="col-md-6">
										<label for="text-input" class="col-form-label text-md-left">City${count}</label> 
											<input type="text" id="${addressData?index}.city" class="form-control"
											name="addressmodel[${addressData?index}].city" placeholder="city" value="${addressData.city}" required/><br> 
									</div>
									<div class="col-md-6">
										<label for="text-input" class="col-form-label text-md-left">State${count}</label> 
										<input type="text" id="${addressData?index}.state" class="form-control"
											name="addressmodel[${addressData?index}].state" value="${addressData.state}" placeholder="state" required/> <br>
									</div>
								</div>
								
								<label for="text-input" class="col-form-label text-md-left">Country${count}</label> 
								<br/><input type="text" id="${addressData?index}.country" class="form-control"
								name="addressmodel[${addressData?index}].country" value="${addressData.country}" placeholder="country" required/> <br>
							
								<input type="hidden" name="addressmodel[${addressData?index}].id" value="${addressData.id!""}"> 
							<#-- Remove Button -->
							<div class="text-center" id="repeater">
								<button type="button" class="btn btn-danger list-remove"
									id="fstaddress">
									<span class="fa fa-minus-circle" style="font-size: 30px;"></span>
								</button>
							</div>
						</div>																
						<hr>
						</div>
						<#assign count++>
						</#list>
					</div>
					
					
					<#else>
					<div id="example1" class="form-group">	
						<#-- add button -->
						<div id="repeater" class="text-center">
								<button type="button" id="rbtn" class="btn btn-success list-add"> 
									<span class="fa fa-plus-circle" style="font-size: 30px;"></span>
								</button>
						</div>
					
							<div class="list-item">
								<div class="form-group" id="addressrow">
									<label class="col-form-label text-md-left" for="text-input">Address</label>
										<input type="text"  name="addressmodel[0].address" id= "0.address"
										class="form-control" placeholder="Address" 
										 onblur="streetValidate(id)" required/>
										<br/> 
										 
								<div class="row">
									<div class="col-md-6">
										<label for="text-input" class="col-form-label text-md-left">City :</label> 
											<input type="text" id="0.city" class="form-control"
											name="addressmodel[0].city" placeholder="city" value="" required/><br> 
									</div>
									<div class="col-md-6">
										<label for="text-input" class="col-form-label text-md-left">State :</label> 
										<input type="text" id="0.state" class="form-control"
											name="addressmodel[0].state" value="" placeholder="state" required/> <br>
									</div>
								</div>
								
								<label for="text-input" class="col-form-label text-md-left">Country :</label> 
								<br/><input type="text" id="0.country" class="form-control"
								name="addressmodel[0].country" value="" placeholder="country" required/> <br>
							
							<#-- Remove Button -->
							<div class="text-center" id="repeater">
								<button type="button" class="btn btn-danger list-remove"
									id="fstaddress">
									<span class="fa fa-minus-circle" style="font-size: 30px;"></span>
								</button>
							</div>
						</div>																
						<hr>
						</div>
					</div>
					</#if>






							<div class="form-group">
								<label for="pwd">Password : </label> <input type="Password"
									class="form-control" name="pwd" id="pwd"
									value="${(userModel.pwd) !""}" placeholder="Enter Password" onblur="inputpassword()"
									onfocus="resetPassword()"><br> <span class="error"
									id="spwd"></span>
							</div>

							<div class="form-group">
								<label for="cpwd">Confirm Password : </label> <input
									type="Password" class="form-control" name="cpwd" id="cpwd"
									value="${(userModel.pwd) !""}" placeholder="Enter Confirm Password" onblur="inputcpassword()"
									onfocus="resetConfirmPassword()"><br> <span
									class="error" id="scpwd"></span>
							</div>

							<div class="form-group">
								<label for="img">Upload Profile : </label><br>
								<div class="d-flex">
									<input type="file" class="form-control-file" name="pic"
										id="pic" accept="image/*" value=""  
										onchange="inputFile() ; readURL(this)" onfocus="resetFile()">
									<input type="hidden" name="base64image" value="${(userModel.base64image)!""}"/>
									<input type="hidden" value="" id="userImage" name="userImage">
									<img id="preview" <#if userModel?has_content>src="data:image/jpg;base64,${userModel.base64image}"</#if> class="rounded float-right"
										<br>
								</div>
								<span class="error" id="spic"></span>
							</div>
							<input type="hidden"  name="id" value="${(userModel.id)!""}">
							<button type="submit" name="register" id="register"
								value=""
								class="btn btn-outline-light btn-lg login-btn-width login-bg" onclick='return validate();'><#if userModel??>Update<#else>SignUp</#if>
							</button>
							
							<#if userModel?has_content>							
							<a class="btn btn-outline-light btn-lg login-btn-width login-bg"
									href="cancle"><span class="fa fa-times-circle mr-1"></span>Cancel</a>
							</#if>
							<br>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
	
	
	
	<!-- Footer -->
	<#include "footer.ftl">
