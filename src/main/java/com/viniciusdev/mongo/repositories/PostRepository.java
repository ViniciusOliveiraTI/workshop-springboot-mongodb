package com.viniciusdev.mongo.repositories;

import com.viniciusdev.mongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
