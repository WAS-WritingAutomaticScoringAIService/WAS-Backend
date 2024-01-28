package com.example.WAS.domain.Task;

import com.example.WAS.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

//    @Override
//    public TaskResponse createTask(TaskRequest request) throws Exception {
//
//        Task task = taskRepository.save(request.toEntity());
//        return new TaskResponse(task);
//    }

    @Override
    public Long createTask(TaskRequest request) throws Exception {

        Task task = taskRepository.save(request.toEntity());
        return task.getId();
    }

    @Override
    public List<Task> search(String keyword) {
        return null;
    }

    // 모든 과제 가져오기
    @Override
    public List<TaskListResponse> findAllTask() {
        List<Task> taskList = taskRepository.findAll();
        List<TaskListResponse> responses = new ArrayList<>();

        for (Task task : taskList) {
            responses.add(new TaskListResponse(task));
        }
        return responses;
    }

//    @Override
//    public List<TaskListResponse> search(String keyword) {
//        List<TaskListResponse> taskList = taskRepository.findAllBySubject(keyword);
//
//        return  taskList;
//    }


}
