package team444.funcourse.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team444.funcourse.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
