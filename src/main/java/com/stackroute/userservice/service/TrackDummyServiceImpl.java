package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExist;
import com.stackroute.userservice.exception.UserNotFound;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
@Qualifier("dummy")
public class TrackDummyServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public TrackDummyServiceImpl(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyExist {
        if(userRepository.existsById(user.getTrackid()))
        {
            throw new UserAlreadyExist("user already exists");

        }
        User SavedUser=userRepository.save(user);
        if(SavedUser==null)
        {
            throw new UserAlreadyExist("already exist");
        }
        return SavedUser;
    }

    @Override

    public List<User> getAllUser() throws UserNotFound{
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int userId) throws UserNotFound {
        userRepository.deleteById(userId);

    }


}