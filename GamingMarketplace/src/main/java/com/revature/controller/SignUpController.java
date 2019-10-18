package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Credential;
import com.revature.model.Player;
import com.revature.service.CredentialService;
import com.revature.service.PlayerService;

@Controller
@RequestMapping(value = "/signup")
public class SignUpController {

	private CredentialService credentialService;

	@Autowired // setter injection
	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}

	private PlayerService playerService;

	@Autowired // setter injection
	public void setItemService(PlayerService playerService) {
		this.playerService = playerService;
	}

	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/createPlayer", method = RequestMethod.POST)
	public void createPlayer(@RequestBody Player player) {
		System.out.println("firstname: " + player.getFirstname());
	}
	
	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/createCredential", method = RequestMethod.POST)
	public void createPlayer(@RequestBody Credential credential) {
		System.out.println("username: " + credential.getUsername());
	}

}
