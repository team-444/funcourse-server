package team444.funcourse.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team444.funcourse.domain.user.dto.CreateUserRequest;
import team444.funcourse.domain.user.entity.User;
import team444.funcourse.domain.user.entity.UserRole;
import team444.funcourse.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(CreateUserRequest request) {
        User user = User.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .nickname(request.getNickname())
            .role(UserRole.USER)
            .build();
        userService.saveUser(user);
    }

}
