package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.model.Player;
import com.revature.service.CredentialService;

@Controller
public class LoginController {
	@Autowired
	private CredentialService credentialService;
	
	// deliver static resources from endpoint "/login"
		@GetMapping(value = "/login")
		public String getStaticLoginPage() {
			return "forward:/resources/Login.html";
		}

		// handle form data sent to "/login"
		@PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
		public RedirectView handleFormRequest(@RequestBody MultiValueMap<String, String> formParams,
				RedirectAttributes attributes) {
			//this will be in an try block
			Player loginPlayer = credentialService.login(formParams.getFirst("username"), formParams.getFirst("password"));
			System.out.println(formParams.getFirst("username"));
			System.out.println(loginPlayer.getCoins());
			attributes.addFlashAttribute("player", loginPlayer);
//			attributes.addFlashAttribute("playerId", loginPlayer.getplayerId());
//			attributes.addFlashAttribute("firstname", loginPlayer.getFirstname());
//			attributes.addFlashAttribute("lastname", loginPlayer.getLastname());
//			attributes.addFlashAttribute("email", loginPlayer.getEmail());
//			attributes.addFlashAttribute("avatarFilename", loginPlayer.getAvatarFilename());
//			attributes.addFlashAttribute("coins", loginPlayer.getCoins());
//			attributes.addFlashAttribute("minutes", loginPlayer.getplayerId());
			attributes.addFlashAttribute("username", formParams.getFirst("username"));
			attributes.addFlashAttribute("password", formParams.getFirst("password"));
			return new RedirectView("profile");
		}
		
		// profile page to which one is redirected after login
		@GetMapping(value="/profile")
		public ModelAndView getProfilePage(@ModelAttribute("player") Player player, ModelMap m) {
		//public ModelAndView getProfilePage(@ModelAttribute("username") String username, ModelMap m) {
			m.addAttribute("player", player);
			return new ModelAndView("profile", m);
		}
		
		@GetMapping(value="/logout")
		public RedirectView LogoutRequest(@RequestParam MultiValueMap<String, String> formParams) {
			if(formParams.getFirst("logout") == null) {
				System.out.println("There was an error  while trying to logout out");
			}
			return new RedirectView("login");
		}
		
		

}
