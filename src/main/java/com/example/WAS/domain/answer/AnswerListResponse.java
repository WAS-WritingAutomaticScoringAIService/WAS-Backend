package com.example.WAS.domain.answer;

import lombok.Getter;

@Getter
public class AnswerListResponse {

    private String name;
    private Long number;
    private String score;

    public AnswerListResponse(Answer answer) {
        this.name = answer.getName();
        this.number = answer.getNumber();
        this.score = answer.getScore();

    }
}
