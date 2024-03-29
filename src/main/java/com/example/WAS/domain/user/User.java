package com.example.WAS.domain.user;

import com.example.WAS.domain.Role;
import com.example.WAS.domain.Task.Task;
import com.example.WAS.domain.base.BaseTimeEntity;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String username;

    // 소속 기관
    @Column(nullable = false, length = 100)
    private String position;

    // 학번, 교번
    @Column(nullable = false, length = 100)
    private String number;

    // 학과
    @Column(nullable = false, length = 50)
    private String department;

    @Enumerated(EnumType.STRING)
    private Role role;



//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Task> tasks;

    public void addUserAuthority() {
        this.role = Role.USER;
    }

    // 비밀번호 암호화
    public User encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
        return this;
    }

    // 비밀번호 확인
    public boolean checkPassword(PasswordEncoder passwordEncoder, String password) {
        return passwordEncoder.matches(this.password, password);
    }

}
