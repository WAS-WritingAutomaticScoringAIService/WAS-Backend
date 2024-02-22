package com.example.WAS.domain.question;

import com.example.WAS.domain.Task.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionResponse {

    private Long QuesNum;
    private String content;
    private Task task;

    public QuestionResponse(Question question) {
        this.QuesNum = question.getQuesNum();
        this.content = question.getContent();
        this.task = question.getTask();
    }
}
