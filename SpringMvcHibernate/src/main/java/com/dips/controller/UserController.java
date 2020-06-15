package com.dips.controller;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dips.model.AddressListDto;
import com.dips.model.UserModel;
import com.dips.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/index" })
	public String displayIndexPage() {
		return "index";
	}

	@RequestMapping("/registration")
	public String displayRegistrationPage() {
		return "registration";
	}

	@RequestMapping("/login")
	public String displayLoginPage() {
		return "login";
	}

	// private List<AddressModel> addressModel;
	@PostMapping("/save")
	public String registrationForm(UserModel userModel, BindingResult result,
			@RequestParam("pic") CommonsMultipartFile file, Model m, AddressListDto addressListDto) {
		// ,AddressModel addressmodel,BindingResult result2
		// UserModel userModel = new UserModel();
		// addressModel = addressmodel;
		System.out.println("addressmodel :" + addressListDto);
		userModel.setAddressModel(addressListDto.getAddressmodel());

		m.addAttribute("userModel", userModel);
		System.out.println("Data is in controller :" + userModel);
		userModel.setPic(file.getBytes());
		userService.addUser(userModel);
		return "index";
	}

	/*
	 * @PostMapping("/logincheck") public ModelAndView showUser(Model m , UserModel
	 * userModel,HttpSession session) { ModelAndView mav = null; userModel =
	 * userService.showData(userModel.getEmail(),userModel.getPwd()); //User user =
	 * userService.validateUser(login); if (null != userModel) { mav = new
	 * ModelAndView("profile"); mav.addObject("userModel", userModel);
	 * session.setAttribute("loginUser", "user"); session.setAttribute("login",
	 * userModel); //mav.addObject("firstname", userModel.getFname()); } else { mav
	 * = new ModelAndView("login"); mav.addObject("message",
	 * "Invalid Details ! try with another"); } return mav; }
	 */

	@PostMapping("/logincheck")
	public ModelAndView showUser(Model m, UserModel userModel, HttpSession session) {
		ModelAndView mav = null;
		System.out.println("Email and password : " + userModel.getEmail() + " : " + userModel.getPwd());
		if (userModel.getEmail().equals("admin@gmail.com") && userModel.getPwd().equals("aaaaaaaa")) {
			// Admin
			List<UserModel> list = userService.getAllUserData();
			mav = new ModelAndView("adminProfile");
			mav.addObject("userModel", list);
			session.setAttribute("loginUser", "adminuser");
			session.setAttribute("loginadmin", list);
			return mav;
		} else {
			userModel = userService.showData(userModel.getEmail(), userModel.getPwd());
			// User user = userService.validateUser(login);
			if (null != userModel) {
				mav = new ModelAndView("profile");
				mav.addObject("userModel", userModel);
				session.setAttribute("loginUser", "user");
				session.setAttribute("login", userModel);
				// mav.addObject("firstname", userModel.getFname());
			} else {
				mav = new ModelAndView("login");
				mav.addObject("message", "Invalid Details ! try with another");
			}
			return mav;
		}
	}

	@PostMapping("/edit")
	public String displayEditForm(Model m, int id, HttpSession session) {
		session.setAttribute("editData", id);
		return "redirect:/editDetailsForm";
	}

	@RequestMapping("/editDetailsForm")
	public String editData(Model m, HttpSession session) {
		UserModel userModel = new UserModel();
		userModel = userService.getData((Integer) session.getAttribute("editData"));
		m.addAttribute("userModel", userModel);
		return "registration";
	}

	@RequestMapping("/cancle")
	public String displayProfilePage(Model m, HttpSession session, UserModel userModel) {
		if (session.getAttribute("loginUser").equals("user")) {
			m.addAttribute("userModel", session.getAttribute("login"));
			return "profile";
		} else {
			m.addAttribute("userModel", session.getAttribute("loginadmin"));
			return "adminProfile";
		}
	}

	@PostMapping("/update")
	public String updateForm(UserModel userModel, BindingResult result, @RequestParam("pic") CommonsMultipartFile file,
			Model m, AddressListDto addressListDto, HttpSession session, int id, String base64image) {
		userModel.setAddressModel(addressListDto.getAddressmodel());

		System.out.println("file is empty or not  :" + file.getSize());
		if (file.getSize() > 0) {
			System.out.println("iffff");
			userModel.setPic(file.getBytes());
		} else {
			System.out.println("elseeee");
			// byte[] byteArray = Base64.decodeBase64(base64image);
			byte[] decodedBytes = Base64.getDecoder().decode(base64image);
			// String decodedString = new String(decodedBytes);
			userModel.setPic(decodedBytes);
		}

		userService.updateUserData(userModel);
		// m.addAttribute("userModel", userModel);
		userModel = userService.getData((Integer) id);
		m.addAttribute("userModel", userModel);
		// m.addAttribute("userModel", session.getAttribute("login"));
		if (session.getAttribute("loginUser").equals("user")) {
			return "profile";
		} else {
			List<UserModel> list = userService.getAllUserData();
			m.addAttribute("userModel",list);
			return "adminProfile";
		}
	}

	@RequestMapping("/logoutuser")
	public String logoutUser(Model m, HttpSession session) {
		session.removeAttribute("loginUser");
		session.invalidate();
		m.addAttribute("logoutmessage", "Logout SuccessFully");
		return "login";
	}
	
	@RequestMapping(value="/DeleteUser{userId}",method = RequestMethod.DELETE)   
	@ResponseBody
	public String deleteUser(@PathVariable("userId")Integer userId) {
		userService.deleteUser(userId);
		return null;   
	}
	
	@RequestMapping("/forgotPassword")
	public String displayForgotPasswordPage() {
		return "forgotPassword";
	}

	@RequestMapping(value = "/GetPassword", method = RequestMethod.POST)
	@ResponseBody
	public String getPassword(String email) {
		String password = userService.getPassword(email);
		System.out.println("password :" + password);
		String message = "";
		if (password != null) {
			message = "Your Password Is : " + password;
			return message;
		} else {
			message = "Please Enter Valid Email Id.....!!!!!";
			return message;
		}
	}
}
