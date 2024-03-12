package com.example.WAS.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public interface UserService {

    Long signUp(SignUpRequest request) throws Exception;
    String login(Map<String, String> users);
    List<Long> getAllUserId();
    Long getLoginUser();
    User getUserById(Long id);

}
