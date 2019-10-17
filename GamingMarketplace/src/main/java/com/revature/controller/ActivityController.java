package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Activity;
import com.revature.service.ActivityService;

@Controller
@RequestMapping(value = "/activity")
public class ActivityController {
	
	private ActivityService activityService;
	private static Logger log = Logger.getRootLogger();
	
	@Autowired // setter injection
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	@ResponseBody // tells spring to skip ViewResolver
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Activity>> getAll() {
		log.info("Someone called the activity/all endpoint");
		return new ResponseEntity<>(this.activityService.getAll(), HttpStatus.OK);
	}

}
