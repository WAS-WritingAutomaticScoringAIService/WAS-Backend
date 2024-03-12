package com.example.WAS.domain.Task;

import com.example.WAS.domain.question.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class TaskResponse {

    private String title;
    private String subject;
    // 분반
    private String cls;
    private List<Question> questions;

    public TaskResponse(Task task) {
        this.title = task.getTitle();
        this.subject = task.getSubject();
        this.cls = task.getCls();
        this.questions = task.getQuestions();
    }

}
