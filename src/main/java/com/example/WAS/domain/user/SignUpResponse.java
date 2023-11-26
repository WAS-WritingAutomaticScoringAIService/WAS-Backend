package com.example.WAS.domain.user;

import com.example.WAS.domain.Role;
import lombok.Getter;

@Getter
public class SignUpResponse {
    private Long id;
    private String email;
    private String password;
//    private String checkedPassword;
    private String username;
    private Role role;
    private String position;
    private String number;
    private String department;

    public SignUpResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
//        this.checkedPassword = checkedPassword;
        this.username = user.getUsername();
        this.role = user.getRole();
        this.position = user.getPosition();
        this.number = user.getNumber();
        this.department = user.getDepartment();
    }

}
