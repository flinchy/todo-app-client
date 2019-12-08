package com.chisom.todo.service;

import com.chisom.todo.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> retrieveAllTasks();
    Task retrieveTaskById(Long id);
    Task createNewTask(Task task);
    Task updateTask(Task task, Long id);
    Task deleteTask(Long id);
}
