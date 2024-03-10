package com.example.WAS.domain.answer;

import com.example.WAS.domain.question.Question;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Builder
public class AnswerRequest {

    private Long id;
    private String content;
    private Question question;

//    public Answer toEntity() {
//        Answer answers Answer.builder()
//                .id(id)
//                .StudentId(StudentId)
//                .number(number)
//                .content(content)
//                .question()
//    }

}
