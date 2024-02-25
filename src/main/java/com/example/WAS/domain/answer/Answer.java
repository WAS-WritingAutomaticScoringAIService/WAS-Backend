package com.example.WAS.domain.answer;

import com.example.WAS.domain.question.Question;
import lombok.*;

import javax.persistence.*;

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

    //test

}
