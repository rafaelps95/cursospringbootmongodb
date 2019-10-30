package com.rafaelpedrodasilva.cursospringbootmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelpedrodasilva.cursospringbootmongo.entities.User;
import com.rafaelpedrodasilva.cursospringbootmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
