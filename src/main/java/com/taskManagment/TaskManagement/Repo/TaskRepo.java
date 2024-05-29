package com.taskManagment.TaskManagement.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.taskManagment.TaskManagement.model.taskModel;

public interface TaskRepo extends MongoRepository<taskModel,String> {
    
}
