package sps.codeinterview.reto2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sps.codeinterview.reto2.model.User;
import sps.codeinterview.reto2.service.IConsumeRestService;

//basepath: /api
@RestController
@RequestMapping("/api")
public class PostsController {

	@Autowired
	private IConsumeRestService consumeRestService;

//get: /user/{userId}
	@GetMapping(path="/user/{userId}")
	public List<User> getUserById(@PathVariable int userId) {

		return consumeRestService.getUserById(userId);
	}

}