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

import com.revature.model.PlayerItem;
import com.revature.service.PlayerItemService;

@Controller
@RequestMapping(value = "/playerItem")
public class PlayerItemController {

	private PlayerItemService playerItemService;

	@Autowired // setter injection
	public void setPlayerItemService(PlayerItemService playerItemService) {
		this.playerItemService = playerItemService;
	}

	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<PlayerItem>> getAll() {
		return new ResponseEntity<>(this.playerItemService.getAll(), HttpStatus.OK);
	}
	
	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/getspecific", method = RequestMethod.POST)
	public ResponseEntity<List<PlayerItem>> getSpecific(@RequestParam int playerId) {
		return new ResponseEntity<>(this.playerItemService.getSpecific(playerId), HttpStatus.OK);
	}

}
