package com.example.WAS.domain.Task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

    @PostMapping("/task/create")
    @ResponseStatus(HttpStatus.OK)
    public Task crateTask(@Valid @RequestBody TaskRequest request) throws Exception {
        return taskService.createTask(request);
    }

    @GetMapping("/task/list")
    public List<TaskListResponse> findAllTask() throws Exception {
        return taskService.findAllTask();
    }

    @GetMapping("/task/list/search")
    public List<TaskListResponse> Search(@RequestParam(value = "keyword") String keyword) throws Exception {
        return taskService.search(keyword);
    }

}
