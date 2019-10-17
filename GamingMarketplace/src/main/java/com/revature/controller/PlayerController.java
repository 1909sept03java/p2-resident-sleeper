package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	//.
	//this will update the avatar of the user
	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/updateavatar", method = RequestMethod.POST)
	public ResponseEntity<Player> updateAvatar(@RequestParam int playerId, String avatarFilename) {
		this.playerService.updateAvatar(playerId, avatarFilename);
		return new ResponseEntity<>(this.playerService.getPlayerById(playerId), HttpStatus.OK);
	}

	//.
	//this will return true if the email is available in the database
	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/isemailunique", method = RequestMethod.POST)
	public ResponseEntity<Boolean> isEmailUnique(@RequestParam String email) {
		if(this.playerService.isEmailUnique(email))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else return new ResponseEntity<>(false, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
		Player player = this.playerService.getPlayerById(id);
		if (player == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(player, HttpStatus.OK);
		}
	}

	//.
	//this will deduct the balance and also update the PlayerItem and Activity table
	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/deductbalace", method = RequestMethod.POST)
	public ResponseEntity<Boolean> deductBalace(@RequestParam int playerId, int itemId) {
		if(this.playerService.deductBalace(playerId, itemId))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else return new ResponseEntity<>(false, HttpStatus.OK);
	}

	//.
	//this will deduct the balance and also update the PlayerItem and Activity table
	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/balanceafterlogout", method = RequestMethod.POST)
	public ResponseEntity<Boolean> balanceAfterLogout(@RequestParam int playerId, int coins) {
		if(this.playerService.balanceAfterLogout(playerId, coins))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else return new ResponseEntity<>(false, HttpStatus.OK);
	}

}
