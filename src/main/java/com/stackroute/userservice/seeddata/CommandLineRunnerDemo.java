package com.stackroute.userservice.seeddata;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner {
@Autowired
private UserRepository userRepository;



    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new User(2,"ganja","bob marley"));

    }
}
