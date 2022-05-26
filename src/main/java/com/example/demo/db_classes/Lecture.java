package com.example.demo.db_classes;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lecture_tab")
@NoArgsConstructor
@Getter
@Setter
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lectureName;
    private LocalTime lectureBegin;
    private LocalTime lectureEnd;
    private final static int maxUsers = 5;

    @ManyToOne
    @JoinTable( name = "event_lecture",
    joinColumns = @JoinColumn(name = "lectureID"),
    inverseJoinColumns = @JoinColumn(name = "eventID"))
    private Event event;

    @ManyToMany
    @JoinTable(name = "lectures_users",
    joinColumns = @JoinColumn(name = "lectureID"),
    inverseJoinColumns = @JoinColumn(name = "userID"))
    private Set<User> usersInOneLecture = new HashSet<>();


}
