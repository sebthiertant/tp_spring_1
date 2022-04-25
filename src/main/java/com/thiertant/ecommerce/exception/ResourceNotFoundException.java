package com.thiertant.ecommerce.exception;
import java.lang.RuntimeException;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        throw new ResourceNotFoundException();
    }
}
