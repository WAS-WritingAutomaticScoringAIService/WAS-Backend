package com.example.WAS.domain.user;

import com.example.WAS.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    @Override
    public Long signUp(SignUpRequest request) throws Exception {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다.");
        }

//        if (!request.getPassword().equals(request.getCheckedPassword())) {
//            throw new Exception("비밀번호가 일치하지 않습니다.");
//        }

        User user = userRepository.save(request.toEntity());

        String password = user.getPassword();

        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(password, salt);

        user.setPassword(hashedPassword);


        user.addUserAuthority();
        return user.getId();
    }

    @Override
    public String login(Map<String, String> users) {

        User user = userRepository.findByEmail(users.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 Email 입니다."));
        System.out.println(user);

        String password = users.get("password");

        System.out.println(user.getPassword());
        if (!BCrypt.checkpw(password,user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }


        List<String> roles = new ArrayList<>();
        roles.add(user.getRole().name());

        System.out.println("OK");

        return jwtTokenProvider.createToken(user.getUsername(), roles);
    }


}
