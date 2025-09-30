package com.viniciusdev.mongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
  public ObjectNotFoundException(String message) {
    super(message);
  }
}
