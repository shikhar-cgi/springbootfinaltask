package com.stackroute.userservice.exception;

public class UserAlreadyExist extends Exception {

   private  String message;

   public UserAlreadyExist()
   {

   }

    public UserAlreadyExist(String message) {
       super(message);
        this.message = message;
    }
}
