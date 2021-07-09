package com.example.admn.controllers;

import com.example.admn.models.User;
import com.example.admn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/public")
public class HomeControllers {
    @GetMapping(value = "/home")
    public HashMap<String,Object> home(){
        User usr = new User();
        usr.setEmail("99999");
        usr.setName("Ali");
        List<User> userList = new ArrayList<>();
        userList.add(usr);
        userList.add(usr);
        userList.add(usr);
        userList.add(usr);
        userList.add(usr);
        userList.add(usr);

        HashMap<String,Object> resMap = new HashMap<>();
        resMap.put("success",true);
        resMap.put("responseCode",200);
        resMap.put("message","All user list");
        resMap.put("data",userList);
        return resMap;
    }

    @GetMapping("/getUser")
    public ResponseEntity<HashMap<String,Object>> getCategory(@RequestParam int userId){
        HashMap<String,Object> resMap = new HashMap<>();
        resMap.put("success",true);
        resMap.put("responseCode",200);
        resMap.put("message","User successfully registered");
        resMap.put("data",userService.getUserById(userId));
        return ResponseEntity.ok(resMap);
    }

    @Autowired
    UserService userService;
    @PostMapping("register")
    public ResponseEntity<HashMap<String,Object>> registerUser(@RequestBody User user){
        User regUser = userService.register(user);



        HashMap<String,Object> resMap = new HashMap<>();
        resMap.put("success",true);
        resMap.put("responseCode",200);
        resMap.put("message","User successfully registered");
        resMap.put("data",user);
        return ResponseEntity.ok(resMap);
    }

    @PostMapping("updateUSer")
    public ResponseEntity<HashMap<String,Object>> updateUser(@RequestBody User user){

        HashMap<String,Object> resMap = new HashMap<>();
        resMap.put("success",true);
        resMap.put("responseCode",200);
        resMap.put("message","User successfully registered");
        resMap.put("data",userService.updaeUSer(user));
        return ResponseEntity.ok(resMap);
    }

    @GetMapping("getAllUser")
    public ResponseEntity<HashMap<String,Object>> getUsers(){


        HashMap<String,Object> resMap = new HashMap<>();
        resMap.put("success",true);
        resMap.put("responseCode",200);
        resMap.put("message","User successfully registered");
        resMap.put("data",userService.getUsers());
        return ResponseEntity.ok(resMap);
    }
}
