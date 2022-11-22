package com.example.project.bookmyshowbackend.Exception;

public class DuplicateEntryException extends RuntimeException{
    private final String message;
    public DuplicateEntryException(String message){
        super(message);
        this.message=message;
    }
}
