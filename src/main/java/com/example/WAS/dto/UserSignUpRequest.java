package com.example.WAS.dto;

import com.example.WAS.domain.Role;
import com.example.WAS.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserSignUpRequest {

    private String email;

    private String password;

    private String checkedPassword;

    private String username;

    private Role role;

    private String group;

    private String number;

    private String department;

    @Builder
    public User toEntity(){
        return User.builder()
                .email(email)
                .username(username)
                .password(password)
                .role(Role.STUDENT)
                .group(group)
                .number(number)
                .department(department)
                .build();
    }
}
