package com.hritik.to_do.list.api.controller;

import com.hritik.to_do.list.api.model.Task;
import com.hritik.to_do.list.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTask()
    {
        List<Task> tasks = taskService.getAllTask();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) throws Exception {
        Task find_task = taskService.getTaskById(id);
        return new ResponseEntity<>(find_task,HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task)
    {
        Task find_task = taskService.createTask(task);
        return new ResponseEntity<>(task,HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) throws Exception {
        Task saved_task = taskService.updateTask(id, task);
        return new ResponseEntity<>(saved_task,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteTask(@PathVariable Long id) throws Exception {
        String message = taskService.deleteTask(id);
        return new ApiResponse(message,"completed");
    }


}

