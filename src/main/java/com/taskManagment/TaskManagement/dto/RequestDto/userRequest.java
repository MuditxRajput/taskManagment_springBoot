package com.taskManagment.TaskManagement.dto.RequestDto;

public class userRequest {
    private String name;
    private String password;

    // getter and setters

    public void setName(String name) {
            this.name = name;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public String getPassword() {
            return password;
    }

    public String getName() {
            return name;
    }
}
