package com.example.WAS.domain.answer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface AnswerService {

   // List<AnswerResponse> findAllAnswer();

    AnswerDetailResponse getAnswerDetail(Long number);
}
