package be.fedei91.todoapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String email;
    private String paswoord;

    public User(String email, String paswoord) {
        this.email = email;
        this.paswoord = paswoord;
    }

    protected User() {}

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }
}
