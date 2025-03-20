package ru.gb.user.model;


//import jakarta.validation.constraints.NotEmpty;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.user.repository.task.model.Task;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    private String userName;

//    @NotEmpty(message = "Электронная почта не должна быть пустой.")
    @Column(name = "email")
    private String userEmail;

//    @NotEmpty(message = "Пароль не должен быть пустым")
    @Column(name = "password")
    private String userPassword;

    @Column(name = "enabled")
    private boolean isEnabled;

    @Column(name = "roleId")
    private Long roleId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Task> tasks;

//    @Column(name = "phone")
//    private String phone;


    public User(String email, String password) {
        this.userEmail = email;
        this.userPassword = password;
    }

    public User(String userEmail, String userPassword, boolean isEnabled) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.isEnabled = isEnabled;
    }


}
