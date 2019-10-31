package com.rafaelpedrodasilva.cursospringbootmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

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

		User maria = new User(null, "Fabricio Mozão Delite", "fafi@gmail.com");
		User alex = new User(null, "Rafael Pedro da Silva", "rafael@gmail.com");
		User bob = new User(null, " Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("16/10/2019"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("31/10/2019"), "Bom dia", "Acordei feliz hoje!", maria);

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
