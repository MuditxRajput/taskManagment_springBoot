package com.taskManagment.TaskManagement.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class userModel {
    @Id
    private String id;
    private String name;
    private String password;
    private List<String> tasksIds = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setTaskIds(List<String> tasksIds)
    {
        this.tasksIds = tasksIds;
    }

    public List<String> getTasksIds()
    {
        return tasksIds;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
