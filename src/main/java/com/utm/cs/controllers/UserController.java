package com.utm.cs.controllers;

import com.utm.cs.errors.EmailAlreadyRegistered;
import com.utm.cs.errors.IncorrectEmailFormat;
import com.utm.cs.errors.IncorrectPasswordFormat;
import com.utm.cs.model.ConfirmationToken;
import com.utm.cs.model.User;
import com.utm.cs.service.ConfirmationTokenService;
import com.utm.cs.service.UserService;
import com.utm.cs.service.validation.BusinessValidationService;
import com.utm.cs.service.validation.StructuralValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {

	private final UserService userService;
	private final ConfirmationTokenService confirmationTokenService;
	private final StructuralValidationService structuralValidationService;
	private final BusinessValidationService businessValidationService;

	@GetMapping("/sign-in")
	public String signIn() {
		return "sign-in";
	}

	@GetMapping("/secret")
	public String loadSecret(){
		return "secret_page";
	}

	@GetMapping("/home")
	public String loadHome(){
		return "home";
	}

	@GetMapping("/sign-up")
	public String signUpPage(User user) {
		return "sign-up";
	}

//	@DeleteMapping("/del/{email}")
//	public String delUser(@PathVariable String email){
//		userService.deleteUser(email);
//		return "home";
//	}

//	@PostMapping
//	public String DmnCatanoiNuPuneti4vaRog(){
//
//	}

	@PostMapping("/logout")
	public String logout() {
		return "sign-in";
	}

	@PostMapping("/sign-up")
	public String signUp(User user) throws IncorrectEmailFormat, EmailAlreadyRegistered, IncorrectPasswordFormat {
		if (!structuralValidationService.validateEmail(user.getEmail()))
			throw new IncorrectEmailFormat();
		if (!structuralValidationService.validatePassword(user.getPassword()))
			throw new IncorrectPasswordFormat();
		if (businessValidationService.validateEmail(user.getEmail()))
				throw new EmailAlreadyRegistered();
		userService.signUpUser(user);
		return "redirect:/sign-in";
	}

	@GetMapping("/sign-up/confirm")
	public String confirmMail(@RequestParam("token") String token) {
		Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);
		optionalConfirmationToken.ifPresent(userService::confirmUser);
		return "redirect:/sign-in";
	}
}