package com.example.WAS.domain.Task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TaskServiceImpl {

    private final TaskRepository taskRepository;

    public TaskResponse createTask(TaskRequest request) throws Exception {

        Task task = new Task(request.toEntity());
        taskRepository.save(task);

        return new TaskResponse(task);
    }

    // 모든 과제 가져오기
    public List<TaskListResponse> findAllTask() {
        List<Task> taskList = taskRepository.findAll();
        List<TaskListResponse> responses = new ArrayList<>();

        for (Task task : taskList) {
            responses.add(new TaskListResponse(task));
        }
        return responses;
    }

    public List<TaskListResponse> search(String keyword) {
        List<TaskListResponse> taskList = taskRepository.findAllBySubject(keyword);

        return  taskList;
    }





}
