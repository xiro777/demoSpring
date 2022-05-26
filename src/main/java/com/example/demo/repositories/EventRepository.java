package com.example.demo.repositories;

import com.example.demo.db_classes.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
