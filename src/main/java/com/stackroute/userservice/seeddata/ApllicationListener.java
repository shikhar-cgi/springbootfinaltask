package com.stackroute.userservice.seeddata;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:application.properties")
public class ApllicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Environment env;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {



        User track=new User();


        track.setTrackComment(env.getProperty("track.trackComment"));
        track.setTrackName(env.getProperty("track.trackName"));

            userRepository.save(track);



    }
}