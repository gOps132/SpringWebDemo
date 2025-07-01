package com.example.ToDo;

import com.example.ToDo.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {
    // define custom queries as needed
}
