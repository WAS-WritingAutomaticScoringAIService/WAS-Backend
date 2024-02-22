package com.example.WAS.domain.Task;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor

// 게시판 전체 목록 조회 시 넘겨줄 response
public class TaskListResponse {

    private String title;
    private String subject;
    // 분반
    private String cls;
    private LocalDateTime endTime;

//    public Task toEntity() {
//        return Task.builder()
//                .title(title)
//                .subject(subject)
//                .cls(cls)
//                .endTime(endTime)
//                .build();
//    }

    public TaskListResponse(Task task) {
        this.title = task.getTitle();
        this.subject = task.getSubject();
        this.cls = task.getCls();
        this.endTime = task.getEndTime();
    }
}
