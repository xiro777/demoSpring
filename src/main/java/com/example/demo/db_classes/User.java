package com.example.demo.db_classes;

import com.example.demo.web.UserRegistrationDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "user_tab")
@Getter
@Setter
public class User {

    @Id
    @SequenceGenerator(name = "user_generator", sequenceName = "user_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public User(){

    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Collection<Role> roles;

    //

    @ManyToMany(mappedBy = "usersInOneLecture")
    private Set<Lecture> lecturesAddedByUser = new HashSet<>();
}
