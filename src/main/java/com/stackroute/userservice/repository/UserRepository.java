package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>
{
@Query("from User where trackName=?1")
   public List<User> findUserByTrackName(String name);
}
