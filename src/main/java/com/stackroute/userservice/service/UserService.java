package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExist;
import com.stackroute.userservice.exception.UserNotFound;

import java.util.List;

public interface UserService {

    public User saveUser(User user) throws UserAlreadyExist;
    public List<User> getAllUser() throws UserNotFound;
    public void deleteUser(int userId) throws UserNotFound;
    public User upadate(User user) throws UserAlreadyExist;
    public List<User> findUserByTrackName(String name) throws UserNotFound;

}
