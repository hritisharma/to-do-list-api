package com.hritik.to_do.list.api.service;

import com.hritik.to_do.list.api.model.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTask();
    public Task getTaskById(Long id) throws Exception;
    public Task createTask(Task task);
    public Task updateTask(Long id , Task task) throws Exception;
    public String deleteTask(Long id) throws Exception;
}
