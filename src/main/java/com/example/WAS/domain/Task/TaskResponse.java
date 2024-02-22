package com.example.WAS.domain.Task;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TaskResponse {

    private String title;
    private String subject;
    // 분반
    private String cls;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    public TaskResponse(Task task) {
        this.title = task.getTitle();
        this.subject = task.getSubject();
        this.cls = task.getCls();
        this.startTime = task.getStartTime();
        this.endTime = task.getEndTime();
    }
}
