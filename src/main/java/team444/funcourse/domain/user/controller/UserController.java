package team444.funcourse.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    @DeleteMapping("/{id}")
    public String deleteUser(
        @PathVariable(name = "id") Long id
    ) {
        return "ok";
    }
}
