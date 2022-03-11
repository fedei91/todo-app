package be.fedei91.todoapp.repositories;

import be.fedei91.todoapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List findAll();
    User findUserByEmail(String email);
}
