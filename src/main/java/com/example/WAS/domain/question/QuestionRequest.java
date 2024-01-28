package com.example.WAS.domain.question;

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

    public Question toEntity() {
        return Question.builder()
                .QuesNum(QuesNum)
                .content(content)
                .build();
    }
}
