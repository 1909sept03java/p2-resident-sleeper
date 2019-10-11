package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Player;
import com.revature.service.PlayerService;

@Controller
@RequestMapping(value = "/player")
public class PlayerController {

	private PlayerService playerService;

	@Autowired // setter injection
	public void setItemService(PlayerService playerService) {
		this.playerService = playerService;
	}

	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Player>> getAll() {
		return new ResponseEntity<>(this.playerService.getAll(), HttpStatus.OK);
	}

}
