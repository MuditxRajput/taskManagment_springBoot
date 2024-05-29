package com.taskManagment.TaskManagement.Repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.taskManagment.TaskManagement.model.userModel;


public interface UserRepo extends MongoRepository<userModel,String> {
      Optional<userModel> findByName(String name);
 

}
