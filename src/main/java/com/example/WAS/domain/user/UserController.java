package com.example.WAS.domain.user;

import com.example.WAS.domain.user.SignUpRequest;
import com.example.WAS.domain.user.UserRepository;
import com.example.WAS.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public Long join(@Valid @RequestBody SignUpRequest request) throws Exception {
        return userService.signUp(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        return userService.login(user);
    }



}
