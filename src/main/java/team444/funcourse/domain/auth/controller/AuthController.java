package team444.funcourse.domain.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team444.funcourse.domain.auth.service.AuthService;
import team444.funcourse.domain.user.dto.CreateUserRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public String createUser(
        @RequestBody CreateUserRequest request
    ) {
        authService.createUser(request);
        return "회원가입 완료";
    }
}
