package com.example.WAS.domain;

import com.example.WAS.domain.base.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

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
    private String group;

    // 학번, 교번
    @Column(nullable = false, length = 100)
    private String number;

    // 학과
    @Column(nullable = false, length = 50)
    private String department;

    @Enumerated(EnumType.STRING)
    private Role role;
}
