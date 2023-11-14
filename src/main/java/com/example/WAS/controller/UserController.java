package com.example.WAS.controller;

import com.example.WAS.dto.UserSignUpRequest;
import com.example.WAS.repository.UserRepository;
import com.example.WAS.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public Long join(@Valid @RequestBody UserSignUpRequest request) throws Exception {
        return userService.signUp(request);
    }


}
