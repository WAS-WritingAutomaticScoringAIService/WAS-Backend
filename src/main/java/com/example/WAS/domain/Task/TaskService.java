package com.example.WAS.domain.Task;

import com.example.WAS.domain.answer.AnswerListResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface TaskService {

    public Taskdto createTask(TaskRequest request) throws Exception;
    public List<TaskListResponse> search(String keyword);
    public List<TaskListResponse> findAllTask();
    AnswerListResponse getAnswersByTaskId(Long taskId);
//    public TaskSubmitDTO submit(TaskSubmitDTO taskSubmitDTO);

}
