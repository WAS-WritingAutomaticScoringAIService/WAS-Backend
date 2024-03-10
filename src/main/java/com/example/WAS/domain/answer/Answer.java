package com.example.WAS.domain.answer;

import com.example.WAS.domain.Task.Task;
import com.example.WAS.domain.question.Question;
import com.example.WAS.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    private String content;

    @OneToOne
    @JoinColumn(name = "ques_num")
    private Question question;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // 성공 후 테스트 2

}
