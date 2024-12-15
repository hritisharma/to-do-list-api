package com.hritik.to_do.list.api.service;

import com.hritik.to_do.list.api.model.Task;
import com.hritik.to_do.list.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImplementation implements TaskService {
    @Autowired
    public TaskRepository taskRepository;
    @Override
    public List<Task> getAllTask() {
        List<Task> tasks_list = taskRepository.findAll();
        return tasks_list;
    }

    @Override
    public Task getTaskById(Long id) throws Exception {
        Optional<Task> find_task = taskRepository.findById(id);
        if(find_task.isEmpty())
        {
            throw new Exception("Task not found with id : " + id);
        }

        return find_task.get();
    }

    @Override
    public Task createTask(Task task) {
        Task create_task = new Task();
        create_task.setTitle(task.getTitle());
        create_task.setDescription(task.getDescription());
        create_task.setStatus(task.getStatus());
        Task saved_task = taskRepository.save(create_task);
        return saved_task;
    }

    @Override
    public Task updateTask(Long id, Task task) throws Exception {
       Task get_task = getTaskById(id);
        if(task.getStatus() != null)
        {
            String status = task.getStatus();
            if((status.equals("pending")) || (status.equals("in-progress")) || (status.equals("completed")))
            {
                get_task.setStatus(task.getStatus());
            }
            else {
                throw new Exception("Invalid status");
            }

        }
       Task saved_task = taskRepository.save(get_task);
       return saved_task;

    }

    @Override
    public String deleteTask(Long id) throws Exception {
        Task find_task = getTaskById(id);
        taskRepository.delete(find_task);
        return "Task deleted Successfully!";
    }
}
