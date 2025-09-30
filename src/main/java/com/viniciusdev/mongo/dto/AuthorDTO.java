package com.viniciusdev.mongo.dto;

import com.viniciusdev.mongo.domain.User;

public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO() {}

    public AuthorDTO(User object) {
        this.id = object.getId();
        this.name = object.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
