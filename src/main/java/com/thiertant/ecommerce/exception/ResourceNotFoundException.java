package com.thiertant.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        throw new ResourceNotFoundException();
    }
}
