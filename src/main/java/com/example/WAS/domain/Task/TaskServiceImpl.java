package com.example.WAS.domain.Task;

import com.example.WAS.domain.question.Question;
import com.example.WAS.domain.question.QuestionRepository;
import com.example.WAS.domain.question.QuestionService;
import com.example.WAS.domain.user.User;
import com.example.WAS.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

//    @Override
//    public Long createTask(TaskRequest request) throws Exception {
//
//        Task task = taskRepository.save(request.toEntity());
//        return task.getId();
//    }

    @Override
    public Task createTask(TaskRequest request) throws Exception {

        Task task = new Task();
        task.setUser(request.getUser());
        task.setTitle(request.getTitle());
        task.setSubject(request.getSubject());
        task.setCls(request.getCls());
        task.setStartTime(request.getStartTime());
        task.setEndTime(request.getEndTime());
        task.setQuestions(request.getQuestions());

        List<Question> questions = request.getQuestions().stream()
                .map(questionDto -> {
                    Question question = new Question();
                    question.setQuesNum(question.getQuesNum());
                    question.setContent(question.getContent());
                    question.setTask(question.getTask());
                    questionRepository.save(question);
                    return question;
                })
                .collect(Collectors.toList());

        task.setQuestions(questions);
        return taskRepository.save(task);

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

    // 과제 검색 (과목으로 검색)
    @Override
    public List<TaskListResponse> search(String keyword) {
        List<Task> tasks = taskRepository.findBySubjectContaining(keyword);
        List<TaskListResponse> responses = new ArrayList<>();

        if (tasks.isEmpty()) System.out.println("검색 결과가 없습니다.");

        for (Task task: tasks) {
            responses.add(new TaskListResponse(task));
        }

        return responses;
    }


}
