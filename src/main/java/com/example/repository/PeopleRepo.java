package com.example.repository;

import com.example.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepo extends JpaRepository<People, Long> {
    @Override
    Optional<People> findById(Long id);

    @Override
    List<People> findAll();

    List<People> findPeopleByLocalDateAfter(LocalDate after);
    List<People> findPeopleByLocalDateBefore(LocalDate before);
    List<People> findPeopleByLocalDateBetween(LocalDate after, LocalDate before);
}
