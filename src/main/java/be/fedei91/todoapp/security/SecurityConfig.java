package be.fedei91.todoapp.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select email as username, password as password, true as enabled" +
                                " from users where email = ?")
                .authoritiesByUsernameQuery("select ?, 'user'");
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .mvcMatchers("/images/**")
                .mvcMatchers("/css/**")
                .mvcMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin(login -> login.loginPage("/login"));
        http.authorizeRequests(
                requests -> requests
                        .mvcMatchers("/").permitAll()
                        .mvcMatchers("/todolist").authenticated());
        http.logout(logout -> logout.logoutSuccessUrl("/"));
    }
}
