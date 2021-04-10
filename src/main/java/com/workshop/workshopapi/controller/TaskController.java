package com.workshop.workshopapi.controller;

import com.workshop.workshopapi.model.entity.Task;
import com.workshop.workshopapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task save(@RequestBody Task task) {
        return repository.save(task);
    }
}
