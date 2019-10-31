package com.rafaelpedrodasilva.cursospringbootmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelpedrodasilva.cursospringbootmongo.entities.Post;
import com.rafaelpedrodasilva.cursospringbootmongo.repository.PostRepository;
import com.rafaelpedrodasilva.cursospringbootmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Post post = repo.findById(id).orElse(null);
		
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return post;
	}
}
