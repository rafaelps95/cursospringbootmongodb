package com.rafaelpedrodasilva.cursospringbootmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafaelpedrodasilva.cursospringbootmongo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
