package com.example.WAS.domain.Task;

import com.example.WAS.domain.answer.Answer;
import com.example.WAS.domain.question.Question;
import com.example.WAS.domain.student.Student;
import com.example.WAS.domain.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subject;

    // 분반
    @Column(nullable = false)
    private String cls;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

}
