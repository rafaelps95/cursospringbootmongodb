package com.rafaelpedrodasilva.cursospringbootmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafaelpedrodasilva.cursospringbootmongo.dto.AuthorDTO;
import com.rafaelpedrodasilva.cursospringbootmongo.entities.Post;
import com.rafaelpedrodasilva.cursospringbootmongo.entities.User;
import com.rafaelpedrodasilva.cursospringbootmongo.repository.PostRepository;
import com.rafaelpedrodasilva.cursospringbootmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		userRepository.deleteAll();

		User fabricio = new User(null, "Fabricio Mozão Delite", "fafi@gmail.com");
		User rafael = new User(null, "Rafael Pedro da Silva", "rafael@gmail.com");
		User lula = new User(null, "Lula da Silva", "lula13@pt.com");
		
		userRepository.saveAll(Arrays.asList(fabricio, rafael, lula));
		
		Post post1 = new Post(null, sdf.parse("16/10/2019"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(fabricio));
		Post post2 = new Post(null, sdf.parse("31/10/2019"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(fabricio));

		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
