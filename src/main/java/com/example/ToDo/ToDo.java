package com.example.ToDo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
public class ToDo {
    @Id
    private String id; // if using String, mongodb uses ObjectId by default
    private String title;
    private Boolean completed;

    public ToDo() {}

    public ToDo(String title) {
        this.title = title;
        this.completed = false;
    }
    
    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Boolean getCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
