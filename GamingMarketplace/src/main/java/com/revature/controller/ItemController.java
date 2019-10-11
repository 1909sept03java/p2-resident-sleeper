package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Item;
import com.revature.service.ItemService;

@Controller
@RequestMapping(value = "/item")
public class ItemController {

	private ItemService itemService;

	@Autowired // setter injection
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> getAll() {
		return new ResponseEntity<>(this.itemService.getAll(), HttpStatus.OK);
	}

}
