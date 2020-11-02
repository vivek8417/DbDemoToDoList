package com.example.dbdemotodolist.exception;

public class ToDoNotFoundException extends Exception {
    public ToDoNotFoundException(String message){
        super(message);
    }
}
