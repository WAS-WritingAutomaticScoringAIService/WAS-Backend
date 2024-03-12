package com.example.WAS.domain.Task;

import com.example.WAS.domain.answer.Answer;
import com.example.WAS.domain.answer.AnswerRepository;
import com.example.WAS.domain.answer.AnswerWrapper;
import com.example.WAS.domain.question.Question;
import com.example.WAS.domain.question.QuestionRepository;
import com.example.WAS.domain.student.Student;
import com.example.WAS.domain.student.StudentRepository;
import com.example.WAS.domain.student.StudentRequest;
import com.example.WAS.domain.user.User;
import com.example.WAS.domain.user.UserRepository;
import com.example.WAS.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/task", produces = "application/json")
@CrossOrigin(origins = "*") // 컨트롤러에서 설정
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskService taskService;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final StudentRepository studentRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    // 과제 생성
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Taskdto crateTask(@Valid @RequestBody TaskRequest request) throws Exception {
        return taskService.createTask(request);
    }

    // 과제 전체 조회
    @GetMapping("/list")
    public List<TaskListResponse> findAllTask() throws Exception {
        return taskService.findAllTask();
    }

    // 과제 검색
    @GetMapping("/list/search")
    public List<TaskListResponse> Search(@RequestParam(value = "keyword") String keyword) throws Exception {
        return taskService.search(keyword);
    }

    // 과제 표시
    @GetMapping("/read/{id}")
    public TaskResponse readTask(@PathVariable Long id) {

        Optional<Task> task = taskRepository.findById(id);
        System.out.println("task.get() = " + task.get().getTitle());
        return new TaskResponse(task.get());

    }

    @PostMapping("/read/{id}/submit")
    public String submit(@PathVariable Long id, @RequestBody AnswerWrapper wrapper) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentEmail = authentication.getName();
//        Optional<User> optionalUser = userRepository.findByEmail(currentEmail);
//        System.out.println("optionalUser = " + optionalUser);
//        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

//        User user = userService.getUserById(userService.getLoginUser());

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

//        Student student = studentRepository.save(request.toEntity());
//        student.setTask(task);

        wrapper.getAnswers().forEach(answerDto -> {
            Answer answer = new Answer();

//            answer.setUser(user);

//            answer.setStudent(student);
            answer.setTask(task);
            answer.setName(answerDto.getName());
            answer.setNumber(answerDto.getNumber());
            answer.setContent(answerDto.getContent());
            answerRepository.save(answer);
        });

        return "Questions received";
    }


    //test

}
