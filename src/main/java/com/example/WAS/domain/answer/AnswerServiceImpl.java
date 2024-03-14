package com.example.WAS.domain.answer;

import com.example.WAS.domain.Task.Task;
import com.example.WAS.domain.question.Question;
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

    public AnswerDetailResponse getAnswerDetail(Long number) {
        Answer answer = answerRepository.findByNumber(number);

        String title = answer.getTask().getTitle();
        String subject = answer.getTask().getSubject();
        List<Question> questions = answer.getTask().getQuestions();
        List<String> questionContent = new ArrayList<>();

        for (Question question : questions) {
            questionContent.add(question.getContent()); // 각 Question에서 text 값만 추출하여 저장
        }

        String name = answer.getName();
        String content = answer.getContent();

        return new AnswerDetailResponse(title, subject, questionContent, name, content);
    }
}
