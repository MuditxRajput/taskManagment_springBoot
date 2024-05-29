package com.taskManagment.TaskManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taskManagment.TaskManagement.Repo.UserRepo;
import com.taskManagment.TaskManagement.dto.RequestDto.userRequest;
import com.taskManagment.TaskManagement.dto.ResponseDto.userResponse;
import com.taskManagment.TaskManagement.model.userModel;

@Service
public class userService {
    
    @Autowired
   private UserRepo userRepo;
      
    public ResponseEntity<String> addUser(userRequest userDetail)
    {
        try {
            Optional<userModel> existedUser = userRepo.findByName(userDetail.getName());
            if(existedUser.isPresent())
            {
               return ResponseEntity.status(HttpStatus.OK).body("User is already present");
            }
            else{
                userModel user = new userModel();
                user.setName(userDetail.getName());
                user.setPassword(userDetail.getPassword());

                userModel addedUser =  userRepo.save(user);

                userResponse userDto = new userResponse();
                userDto.setName(addedUser.getName());
                userDto.setId(addedUser.getId());
                userDto.setTaskIds(addedUser.getTasksIds());
                String msg = "User is added in system " + userDto;
                return  ResponseEntity.status(HttpStatus.CREATED).body(msg);
                

            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
       
    }

    // update the detail of users...

    public ResponseEntity<String> updateUser(String id,userModel userDetail)
    {
        try {
            Optional<userModel> userDataFromDb = userRepo.findById(id);
            if(userDataFromDb.isPresent())
            {   
                
                userModel existedUser = userDataFromDb.get();
                existedUser.setName(userDetail.getName());
                existedUser.setPassword(userDetail.getPassword());
                userRepo.save(existedUser);
                return ResponseEntity.status(HttpStatus.OK).body("User is update");
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user is not found");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public ResponseEntity<String> deleteUser(String id)
    {
        try {
            Optional<userModel> userFromDb = userRepo.findById(id);
            if(userFromDb.isPresent())
            {
                userModel existedUser = userFromDb.get();
                userRepo.delete(existedUser);
                return ResponseEntity.status(HttpStatus.OK).body("User is delete");
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid user");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
   
}
