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

}
