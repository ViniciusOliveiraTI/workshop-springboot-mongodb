package com.viniciusdev.mongo.repositories;

import com.viniciusdev.mongo.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
