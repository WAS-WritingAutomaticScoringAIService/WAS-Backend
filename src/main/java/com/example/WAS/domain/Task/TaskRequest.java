package com.example.WAS.domain.Task;

import com.example.WAS.domain.question.Question;
import com.example.WAS.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TaskRequest {

    private String title;
    private String subject;
    // 분반
    private String cls;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Question> questions;
    private User user;

    public Task toEntity() {
        return Task.builder()
                .user(user)
                .title(title)
                .subject(subject)
                .cls(cls)
                .startTime(startTime)
                .endTime(endTime)
                .questions(questions)
                .build();
    }

//    public void TaskDto() {
//        this.questions = new ArrayList<>();
//    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }
}
