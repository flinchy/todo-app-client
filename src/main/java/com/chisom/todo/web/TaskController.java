package com.chisom.todo.web;

import com.chisom.todo.entity.MyResponseEntity;
import com.chisom.todo.entity.Task;
import com.chisom.todo.repository.TaskRepository;
import com.chisom.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public MyResponseEntity<List<Task>> getAllTask() {
        List<Task> task = taskService.retrieveAllTasks();
        return new MyResponseEntity<>(HttpStatus.OK, "Successful", task);
    }




}
