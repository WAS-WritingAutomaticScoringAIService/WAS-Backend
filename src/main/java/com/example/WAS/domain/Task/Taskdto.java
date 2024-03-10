package com.example.WAS.domain.Task;

import com.example.WAS.domain.question.Question;
import com.example.WAS.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Taskdto {

    private Long id;
    private String title;
    private String subject;
    private String cls;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

//    private User user;

    private List<Question> questions = new ArrayList<>();

}
