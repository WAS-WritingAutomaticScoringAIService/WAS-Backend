package com.example.WAS.domain.Task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    public TaskResponse createTask(TaskRequest request);
    public List<Task> search(String keyword);

}
