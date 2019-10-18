package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Credential;
import com.revature.model.Player;
import com.revature.service.CredentialService;
import com.revature.service.PlayerService;

@Controller
@RequestMapping(value = "/signup")
public class SignUpController {

	private PlayerService playerService;

	@Autowired // setter injection
	public void setItemService(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	private CredentialService credentialService;

	@Autowired // setter injection
	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}
	
	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createPlayer(@RequestParam String email, String firstname, String lastname, String username,
			String password) {
		System.out.println(email);
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(username);
		System.out.println(password);
		Player player = new Player(email, firstname, lastname, "redX.jpg", 100, 0);
		playerService.addPlayer(player);
		Credential credential = new Credential(username, password, player);
		credentialService.addCredential(credential);
	}

}
