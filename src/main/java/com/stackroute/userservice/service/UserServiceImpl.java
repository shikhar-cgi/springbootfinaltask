package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExist;
import com.stackroute.userservice.exception.UserNotFound;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Qualifier("UserService")
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

      @Autowired
     public UserServiceImpl(UserRepository userRepository)
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

    @Override
    public User upadate(User user) throws UserAlreadyExist {
        User updateUser=userRepository.getOne(user.getTrackid());
        updateUser.setTrackComment(user.getTrackComment());
        userRepository.save(updateUser);
        return updateUser;
    }

    @Override
    public List<User> findUserByTrackName(String name) throws UserNotFound {
        List<User> one=userRepository.findUserByTrackName(name);
        if(one.size()==0)
        {
            throw new UserNotFound("User not found");
        }
        return one;
    }
}
