package com.viniciusdev.mongo.services;

import com.viniciusdev.mongo.domain.User;
import com.viniciusdev.mongo.dto.UserDTO;
import com.viniciusdev.mongo.repositories.UserRepository;
import com.viniciusdev.mongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User fromDTO(UserDTO objectDto) {
        return new User(objectDto.getId(), objectDto.getName(), objectDto.getEmail());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User object) {
        return userRepository.insert(object);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

}
