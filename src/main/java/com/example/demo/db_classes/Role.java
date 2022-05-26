package com.example.demo.db_classes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role_tab")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role_name;

    public Role(){

    }

    public Role(String role_name) {
        this.role_name = role_name;
    }
}
