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

    @GetMapping("/tasks/{id}")
    public MyResponseEntity<Task> getTaskById(@PathVariable  Long id) {
        Task taskId = taskService.retrieveTaskById(id);
        return new MyResponseEntity<>(HttpStatus.OK, "Successful", taskId);
    }

    @PostMapping("/tasks")
    public MyResponseEntity<Task>createTask(@RequestBody Task task) {
        Task saveTask = taskService.createNewTask(task);
        return new MyResponseEntity<>(HttpStatus.CREATED, "Task created Successfully", saveTask);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tasks/{id}")
    public MyResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Long id) {
        Task newTask = taskService.updateTask(task, id);
        return new MyResponseEntity<>(HttpStatus.OK, "Task updated successfully", newTask);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{id}")
    public MyResponseEntity<Task> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new MyResponseEntity<>(HttpStatus.OK, "Task deleted successfully");
    }
}
