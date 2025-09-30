package com.viniciusdev.mongo.config;

import com.viniciusdev.mongo.domain.Post;
import com.viniciusdev.mongo.domain.User;
import com.viniciusdev.mongo.dto.AuthorDTO;
import com.viniciusdev.mongo.repositories.PostRepository;
import com.viniciusdev.mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, Instant.now(), "Partiu viagem!", "Vou partir para Sào Paulo. Abraços", new AuthorDTO(maria));
        Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

    }

}
