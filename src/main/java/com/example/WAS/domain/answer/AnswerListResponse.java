package com.example.WAS.domain.answer;

import com.example.WAS.domain.Task.Task;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AnswerListResponse {

    private String title;
    private String subject;
    private String cls;
    private List<AnswerResponse> answers;

    public AnswerListResponse(String title, String subject, String cls, List<Answer> answers) {
        this.title = title;
        this.subject = subject;
        this.cls = cls;
        this.answers = answers.stream()
                .map(AnswerResponse::new)
                .collect(Collectors.toList());
    }
}
