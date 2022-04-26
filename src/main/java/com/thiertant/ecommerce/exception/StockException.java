package com.thiertant.ecommerce.exception;

public class StockException extends Exception{

    private String message;

    public StockException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
