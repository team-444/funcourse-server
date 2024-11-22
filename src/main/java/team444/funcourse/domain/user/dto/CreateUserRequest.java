package team444.funcourse.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class CreateUserRequest {

    private String email;
    private String password;
    private String nickname;
}
