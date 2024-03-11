package com.example.WAS.domain.Task;

import com.example.WAS.domain.answer.Answer;
import com.example.WAS.domain.answer.AnswerRepository;
import com.example.WAS.domain.answer.AnswerWrapper;
import com.example.WAS.domain.user.User;
import com.example.WAS.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/task", produces = "application/json")
@CrossOrigin(origins = "http://front-server.com") // 컨트롤러에서 설정
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskService taskService;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    // 과제 생성
    @PostMapping("/task/create")
    @ResponseStatus(HttpStatus.OK)
    public Taskdto crateTask(@Valid @RequestBody TaskRequest request) throws Exception {
        return taskService.createTask(request);
    }

    // 과제 전체 조회
    @GetMapping("/task/list")
    public List<TaskListResponse> findAllTask() throws Exception {
        return taskService.findAllTask();
    }

    // 과제 검색
    @GetMapping("/task/list/search")
    public List<TaskListResponse> Search(@RequestParam(value = "keyword") String keyword) throws Exception {
        return taskService.search(keyword);
    }

    // 과제 표시
    @GetMapping("/task/read/{id}")
    public TaskReadDTO readTask(@PathVariable Long id) {
        Optional<TaskReadDTO> task = taskRepository.findProjectedById(id);
        return task.get();
    }

    @PostMapping("/task/read/{id}/submit")
    public String submit(@PathVariable Long id, @RequestBody AnswerWrapper wrapper) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUsername = authentication.getName();
//        Optional<User> optionalUser = userRepository.findByUsername(currentUsername);
//
//        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        wrapper.getAnswers().forEach(answerDto -> {
            Answer answer = new Answer();

           // answer.setUser(user);
            answer.setTask(task);
            answer.setContent(answerDto.getContent());
            answerRepository.save(answer);
        });

        return "Questions received";
    }




}
