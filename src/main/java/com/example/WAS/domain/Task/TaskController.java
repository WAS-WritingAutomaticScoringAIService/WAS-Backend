package com.example.WAS.domain.Task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

    @PostMapping("/task/create")
    @ResponseStatus(HttpStatus.OK)
    public Long crateTask(@Valid @RequestBody TaskRequest request) throws Exception {

        return taskService.createTask(request);
    }




}
