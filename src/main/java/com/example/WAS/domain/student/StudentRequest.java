package com.example.WAS.domain.student;

import com.example.WAS.domain.Role;
import com.example.WAS.domain.Task.Task;
import com.example.WAS.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentRequest {

    private String name;
    private Long number;
//    private Task task;

    public Student toEntity() {
        return Student.builder()
                .name(name)
                .number(number)
   //             .task(task)
                .build();
    }

}
