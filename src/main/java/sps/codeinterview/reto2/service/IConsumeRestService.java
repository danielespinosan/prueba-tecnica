/**
 * 
 */
package sps.codeinterview.reto2.service;

import java.util.List;

import sps.codeinterview.reto2.model.User;

/**
 * 
 */
public interface IConsumeRestService {
	
	List<User> getUserById(int userId);

}
