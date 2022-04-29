package edu.uaslp.objetos.exceptions;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String message){
        super((message));
    }
}
