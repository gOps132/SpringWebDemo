package com.example.ToDo;

import com.example.ToDo.ToDo;
import com.example.ToDo.ToDoRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/todos")
@CrossOrigin // or allowedOrigins if you want to limit access
public class ToDoController {

    private final ToDoRepository repository; 
 
    // annotation that tells spring container to inject a bean into class without manually creating it
    @Autowired
    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    // base mapping /todos default get
    @GetMapping
    public List<ToDo> getAllToDos() {
        return repository.findAll(); 
    }
    
    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable String id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Todo not found"));
    }
    
    @PostMapping
    public ToDo createToDo(@RequestParam(required = false) String title) {
        return repository.save(new ToDo(title));
    }
    
    @PutMapping("/{id}")
    public ToDo updateToDo( @PathVariable String id,
                            @RequestBody ToDo updated) {
        ToDo todo = getToDoById(id);
        if (updated.getTitle() != null) todo.setTitle(updated.getTitle());
        if (updated.getCompleted() != null) todo.setCompleted(updated.getCompleted());
        return repository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable String id) {
        repository.deleteById(id);
    }
}

