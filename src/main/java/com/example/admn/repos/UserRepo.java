package com.example.admn.repos;

import com.example.admn.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query("SELECT u from User u where u.id = :id")
    User findUserById(@Param("id") int id);

    @Query("SELECT u from User u where u.email = :email")
    User findUserByEmail(@Param("email") String email);
}