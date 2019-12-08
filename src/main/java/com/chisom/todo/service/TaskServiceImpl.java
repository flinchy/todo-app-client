package com.chisom.todo.service;

import com.chisom.todo.entity.Task;
import com.chisom.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> retrieveAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task retrieveTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
         return optionalTask.orElseThrow(TaskNotFoundException::new);
    }

    @Override
    public Task createNewTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task, Long id) {
       Optional<Task> taskId = taskRepository.findById(id);
       if(taskId.isPresent()) {
           return taskRepository.save(task);

       } else {
           return taskId.orElseThrow(TaskNotFoundException::new);
       }
    }

    @Override
    public Task deleteTask(Long id) {
        Optional<Task> taskId = taskRepository.findById(id);
        if(taskId.isPresent()) {
            taskRepository.deleteById(id);

        } else {
            taskId.orElseThrow(TaskNotFoundException::new);
        }
        return null;
    }

}
