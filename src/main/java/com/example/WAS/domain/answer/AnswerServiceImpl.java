package com.example.WAS.domain.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
//
//    // 모든 답변 가져오기
//    public List<AnswerResponse> findAllAnswer() {
//        List<Answer> answers = answerRepository.findAll();
//        List<AnswerResponse> responses = new ArrayList<>();
//
//        for (Answer answer : answers) {
//            responses.set
//            responses.add(new AnswerResponse(answer));
//        }
//        return responses;
//    }
}
