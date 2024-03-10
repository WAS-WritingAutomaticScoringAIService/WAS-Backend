package com.example.WAS.domain.Task;

import com.example.WAS.domain.answer.Answer;
import com.example.WAS.domain.answer.AnswerRepository;
import com.example.WAS.domain.answer.AnswerRequest;
import com.example.WAS.domain.question.Question;
import com.example.WAS.domain.question.QuestionRepository;
import com.example.WAS.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

//    @Override
//    public Long createTask(TaskRequest request) throws Exception {
//
//        Task task = taskRepository.save(request.toEntity());
//        return task.getId();
//    }

    @Override
    public Taskdto createTask(TaskRequest request) throws Exception {

        Task task = Task.builder()
//                .user(request.getUser())
                .title(request.getTitle())
                .subject(request.getSubject())
                .cls(request.getCls())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .questions(null)
                .build();
        taskRepository.save(task);

        List<Question> questions = request.getQuestions().stream()
                .map(questionDto -> {
                    Question q = Question.builder()
                            .QuesNum(questionDto.getQuesNum())
                            .content(questionDto.getContent())
                            .task(task)
                            .build();
                    System.out.println("questionDto.getQuesNum() : " + questionDto.getQuesNum());
                    System.out.println("Task.getId() : " + task.getId());
                    questionRepository.save(q);
                    return q;
                })
                .collect(Collectors.toList());

        task.setQuestions(questions);

        return Taskdto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .subject(task.getSubject())
                .cls(task.getCls())
                .startTime(task.getStartTime())
                .endTime(task.getEndTime())
                .questions(questions)
                .build();
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
