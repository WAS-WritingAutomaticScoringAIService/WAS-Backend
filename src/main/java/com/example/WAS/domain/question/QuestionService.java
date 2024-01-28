package com.example.WAS.domain.question;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface QuestionService {
    void save(QuestionRequest request);

}
