package com.example.WAS.domain.Task;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor

// 게시판 전체 목록 조회 시 넘겨줄 response
public class TaskListResponse {

    private Long id;
    private String title;
    private String subject;
    // 분반
    private String cls;
    private LocalDateTime endTime;

    public TaskListResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.subject = task.getSubject();
        this.cls = task.getCls();
        this.endTime = task.getEndTime();
    }
}
