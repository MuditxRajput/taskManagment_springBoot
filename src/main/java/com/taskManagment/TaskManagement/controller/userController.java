package com.taskManagment.TaskManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskManagment.TaskManagement.dto.RequestDto.userRequest;
import com.taskManagment.TaskManagement.model.userModel;
import com.taskManagment.TaskManagement.service.userService;


@RestController
@RequestMapping("api/users")
public class userController {
        
    @Autowired
    private userService service;

    @PostMapping()
    public ResponseEntity<String> postMethodName(@RequestBody userRequest user) {
        //TODO: process POST request
        
        return service.addUser(user);
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateController(@PathVariable String id, @RequestBody userModel userDetails)
    {
       return service.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteController(@PathVariable String id)
    {
        System.out.println(id);
        return service.deleteUser(id);
    }
    
}
