package be.fedei91.todoapp.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RegisterForm {
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;

    public RegisterForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
