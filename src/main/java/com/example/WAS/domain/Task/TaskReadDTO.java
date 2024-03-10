package com.example.WAS.domain.Task;

import com.example.WAS.domain.question.Question;

import java.util.List;

public interface TaskReadDTO {

    String getSubject();
    String getCls();
    String getTitle();
    List<Question> getQuestions();

}
