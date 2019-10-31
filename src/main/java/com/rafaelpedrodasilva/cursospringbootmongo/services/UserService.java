package com.rafaelpedrodasilva.cursospringbootmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelpedrodasilva.cursospringbootmongo.dto.UserDTO;
import com.rafaelpedrodasilva.cursospringbootmongo.entities.User;
import com.rafaelpedrodasilva.cursospringbootmongo.repository.UserRepository;
import com.rafaelpedrodasilva.cursospringbootmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElse(null);
		
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
}
