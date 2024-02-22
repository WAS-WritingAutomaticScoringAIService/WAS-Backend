package com.example.WAS.domain.question;

import com.example.WAS.domain.Task.Task;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long QuesNum;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

}
