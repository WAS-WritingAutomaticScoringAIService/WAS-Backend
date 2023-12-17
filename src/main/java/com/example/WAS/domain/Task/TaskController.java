package com.example.WAS.domain.Task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponse crateTask(@Valid @RequestBody TaskRequest request) {

        TaskResponse task = taskService.createTask(request);
        return task;
    }

//    @GetMapping("/id}")
//    public String show(@PathVariable Long id, Model model){
//
//        log.info("id : "+ id);
//
//        //1. id로 데이터를 가져옴
//        // Optional<Article> articleEntity = articleRepository.findById(id); 자바8버전부터 제네릭코드를 이용해서 적용가능하나 일단 지양.
//        Optional<Task> taskEntity = taskRepository.findById(id);
//
//        //2. 가져온 데이터를 모델에 등록
//        model.addAttribute("task", taskEntity);
//
//        //3. 보여줄 페이지를 설정
//        return "task/show";
//    }



}
