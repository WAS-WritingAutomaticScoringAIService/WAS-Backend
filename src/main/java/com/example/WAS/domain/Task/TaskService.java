package com.example.WAS.domain.Task;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface TaskService {

    public Task createTask(TaskRequest request) throws Exception;
    public List<TaskListResponse> search(String keyword);
    public List<TaskListResponse> findAllTask();

}
