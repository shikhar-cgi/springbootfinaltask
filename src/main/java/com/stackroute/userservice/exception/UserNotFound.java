package com.stackroute.userservice.exception;

public class UserNotFound extends Exception {
    String message;

   UserNotFound()
   {

   }

    public UserNotFound(String message) {
        super(message);
        this.message = message;
    }
}
