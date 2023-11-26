package com.example.WAS.domain.user;

import com.example.WAS.domain.Role;
import lombok.*;

@Getter
@Setter
public class SignUpRequest {

    private String email;
    private String password;
    private String checkedPassword;
    private String username;
    private Role role;
    private String position;
    private String number;
    private String department;

    public User toEntity() {
        User user = User.builder()
                .email(email)
                .password(password)
                .username(username)
                .role(Role.USER)
                .position(position)
                .number(number)
                .department(department)
                .build();
        return user;
    }
}
