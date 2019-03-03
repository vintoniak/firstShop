package ua.pp.shop.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.shop.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
