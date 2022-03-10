package be.fedei91.todoapp.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql("/insertUser.sql")
class UserRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String USERS = "users";
    private final UserRepository userRepository;

    UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private long idVanTest() {
        return jdbcTemplate.queryForObject(
                "select id from users where email = 'test@email.org'", Long.class
        );
    }

    @Test
    void findAll() {
        assertThat(userRepository.findAll())
                .hasSize(countRowsInTable(USERS));
    }

    @Test
    void findById() {
        assertThat(userRepository.findById(idVanTest()))
                .hasValueSatisfying(
                        user -> assertThat(user.getEmail()).isEqualTo("test@email.org")
                );
    }
}
