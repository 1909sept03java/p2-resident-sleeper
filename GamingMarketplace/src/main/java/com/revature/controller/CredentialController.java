package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Credential;
import com.revature.service.CredentialService;

@Controller
@RequestMapping(value = "/credential")
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

}
