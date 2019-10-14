package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Credential;
import com.revature.model.Player;
import com.revature.service.CredentialService;

@Controller
@RequestMapping(value = { "/credential","/login"})
public class CredentialController {

	private CredentialService credentialService;

	@Autowired // setter injection
	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}

	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Credential>> getAll() {
		return new ResponseEntity<>(this.credentialService.getAll(), HttpStatus.OK);
	}
	
	//.
	//returns the player profile if the credentials are correct
	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Player> getLogin(@RequestParam String username, String password) {
		Player player = credentialService.login(username, password);
		if(player != null) {
			return new ResponseEntity<Player>(player, HttpStatus.OK);
		}else {
			return new ResponseEntity<Player>(player,HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
