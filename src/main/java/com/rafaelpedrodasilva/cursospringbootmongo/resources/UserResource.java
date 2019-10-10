package com.rafaelpedrodasilva.cursospringbootmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelpedrodasilva.cursospringbootmongo.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User(1L, "Maria Silva", "maria@gmail.com");
		User fabricio = new User(2L, "Fabricio Delite", "fafi@gmail.com");
		User rafael = new User(3L, "Rafael Delite", "rafa@gmail.com");
		
		return ResponseEntity.ok().body(Arrays.asList(maria, fabricio, rafael));
	}
}
