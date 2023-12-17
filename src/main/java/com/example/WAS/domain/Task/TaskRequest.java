package com.example.WAS.domain.Task;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TaskRequest {

    private String title;
    private String subject;
    // 분반
    private Integer cls;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Task toEntity() {
        return Task.builder()
                .title(title)
                .subject(subject)
                .cls(cls)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
