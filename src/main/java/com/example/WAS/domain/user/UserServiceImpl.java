package com.example.WAS.domain.user;

import com.example.WAS.jwt.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
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

    @Override
    public List<Long> getAllUserId() {
        List<User> users= userRepository.findAll();
        List<Long> idList=new ArrayList<>();
        for(User user:users){
            idList.add(user.getId());
        }
        return idList;
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "해당하는 회원이 없습니다."));
    }

    public Long getLoginUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getPrincipal().equals("anonymousUser")){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"다시 로그인하세요");
        }
        User user = (User) authentication.getPrincipal();
        return user.getId();
    }



}
