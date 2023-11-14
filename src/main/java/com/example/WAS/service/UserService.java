package com.example.WAS.service;

import com.example.WAS.domain.User;
import com.example.WAS.dto.UserSignUpRequest;
import com.example.WAS.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long signUp(UserSignUpRequest requestDto) throws Exception {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }
        if (!requestDto.getPassword().equals(requestDto.getCheckedPassword())) {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }

        User user = userRepository.save(requestDto.toEntity());

        user.addUserAuthority();
        return user.getId();
    }



}
