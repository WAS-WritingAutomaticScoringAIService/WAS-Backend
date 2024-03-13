package com.example.WAS.domain.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/answer", produces = "application/json")
@CrossOrigin(origins = "*") // 컨트롤러에서 설정
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("/list")
    public List<AnswerListResponse> getAnswerList() throws Exception {
        return answerService.findAllAnswer();
    }
}
