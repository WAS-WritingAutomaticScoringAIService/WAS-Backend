package com.example.WAS.domain.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/answer", produces = "application/json")
@CrossOrigin(origins = "*") // 컨트롤러에서 설정
public class AnswerController {

    private final AnswerService answerService;
//
//    @GetMapping("/list")
//    public List<AnswerResponse> getAnswerList() throws Exception {
//        return answerService.findAllAnswer();
//    }

    @GetMapping("/{number}")
    public AnswerDetailResponse getAnswerDetail(@PathVariable Long number) {
        return answerService.getAnswerDetail(number);
    }
}
