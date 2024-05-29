package com.taskManagment.TaskManagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "tasks")
public class taskModel {
    @Id
    private String id;
    private String title;
    private String status;

    public String getTitle()
    {
        return title;
    }
    public String getStatus()
    {
        return status;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    
}
