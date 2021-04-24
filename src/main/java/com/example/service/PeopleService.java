package com.example.service;

import com.example.model.DateAfterAndBefore;
import com.example.model.People;
import com.example.repository.PeopleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PeopleService {
    PeopleRepo repo;

    public List<People> findAll(){
        return repo.findAll();
    }
    public People createByData(People people) {
        return repo.save(people);
    }


    public List<People> findPeopleByLocalDateBetween(DateAfterAndBefore data) {
        return repo.findPeopleByLocalDateBetween(data.getAfter(),data.getBefore());
    }

    public List<People> findPeopleByLocalDateAfter(LocalDate after) {
        return repo.findPeopleByLocalDateAfter(after);
    }
    public List<People> findPeopleByLocalDateBefore(LocalDate before){
        return repo.findPeopleByLocalDateBefore(before);
    }
}
