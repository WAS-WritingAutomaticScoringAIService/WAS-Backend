package com.example.WAS.domain.answer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnswerWrapper {
    private List<Answer> answers;

    public AnswerWrapper() {
    }
}
