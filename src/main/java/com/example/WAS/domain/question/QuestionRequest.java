package com.example.WAS.domain.question;

import com.example.WAS.domain.Task.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class QuestionRequest {

    private Long QuesNum;
    private String content;
    private Task task;

    public Question toEntity() {
        return Question.builder()
                .QuesNum(QuesNum)
                .content(content)
                .task(task)
                .build();
    }
}
