package com.example.WAS.domain.answer;

import com.example.WAS.domain.Task.Task;
import com.example.WAS.domain.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AnswerController {

//    @PostMapping("/task/read/{task_id}/submit")
//    public String submit(@PathVariable Task task, @RequestBody AnswerWrapper wrapper) {
//        wrapper.getAnswers().forEach(question ->
//                System.out.println(question.getContent() + ": " + question.getContent())
//        );
//
//        return "Questions received";
//    }



}
