/**
 * 
 */
package sps.codeinterview.reto2.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sps.codeinterview.reto2.model.User;
import sps.codeinterview.reto2.service.IConsumeRestService;

/**
 * 
 */
@Service
public class ConsumeRestServiceImp implements IConsumeRestService {

	@Override
	public List<User> getUserById(int userId) {
		RestTemplate restTemplate;
		List<User> userListService = null;
		List<User> userListFinal = null;
		try {
			
			restTemplate = new RestTemplate();
			ResponseEntity<User[]> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", User[].class);
			User[] users = response.getBody();
			userListService = Arrays.asList(users);
			userListFinal = userListService.stream().filter(user -> user.getUserId()==userId).toList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return userListFinal;
	}
	


}
