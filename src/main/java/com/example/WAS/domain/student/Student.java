package com.example.WAS.domain.student;

import com.example.WAS.domain.Task.Task;
import com.example.WAS.domain.answer.Answer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long number;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

//    //@JsonManagedReference
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    private List<Answer> answers = new ArrayList<>();


}
