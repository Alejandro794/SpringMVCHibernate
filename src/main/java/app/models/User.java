package app.models;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 15, message = "Name should be in the range of 2 to 15 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 1, max = 25, message = "Surname should be in the range of 1 to 25 characters")
    @Column(name = "surname")
    private String surname;

    @NotEmpty(message = "Date of Birth should not be empty")
    @Pattern(regexp = "\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d", message = "Date format should be dd.mm.yyyy")
    @Column(name = "date_of_birth")
    private String date;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid (ivanov@mail.com)")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(String name, String surname, String date, String email) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
