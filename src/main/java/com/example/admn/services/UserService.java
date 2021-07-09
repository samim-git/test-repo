package com.example.admn.services;

import com.example.admn.models.User;
import com.example.admn.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public User register(User user){
        try{
            return userRepo.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public User updaeUSer(User user){
        int userId = user.getId();
        try{
            User updateUser = userRepo.findUserById(userId);

            if(updateUser != null){
                updateUser = user;
                return userRepo.save(updateUser);
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<User> getUsers(){
        try{
            return userRepo.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public User getUserById(int id){
        try{
            return userRepo.findUserById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
