package com.viniciusdev.mongo.resources;

import com.viniciusdev.mongo.domain.Post;
import com.viniciusdev.mongo.domain.User;
import com.viniciusdev.mongo.dto.UserDTO;
import com.viniciusdev.mongo.services.UserService;
import jdk.jshell.EvalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();
        List<UserDTO> usersDto = users
                .stream()
                .map(obj -> new UserDTO(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User object = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(object));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objectDto) {
        User object = userService.fromDTO(objectDto);
        object = userService.insert(object);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(object.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO objectDto, @PathVariable String id) {
        User object = userService.fromDTO(objectDto);
        object.setId(id);
        object = userService.update(object);
        return ResponseEntity.ok().body(new UserDTO(object));
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User object = userService.findById(id);
        return ResponseEntity.ok().body(object.getPosts());
    }

}
