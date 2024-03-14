package com.example.WAS.domain.answer;

import com.example.WAS.domain.question.Question;
import lombok.Getter;

import java.util.List;

@Getter
public class AnswerDetailResponse {

    private String title;
    private String subject;
    private List<String> questionContent;
    private String name;
    private String content;

    public AnswerDetailResponse(String title, String subject, List<String> questionContent, String name, String content) {
        this.title = title;
        this.subject = subject;
        this.questionContent = questionContent;
        this.name = name;
        this.content = content;
    }
}
