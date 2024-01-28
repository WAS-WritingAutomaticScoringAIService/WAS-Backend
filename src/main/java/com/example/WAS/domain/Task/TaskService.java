package com.example.WAS.domain.Task;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface TaskService {

    public Long createTask(TaskRequest request) throws Exception;
    public List<Task> search(String keyword);
    public List<TaskListResponse> findAllTask();

}
