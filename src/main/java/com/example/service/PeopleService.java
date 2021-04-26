package com.example.service;

import com.example.model.DateAfterAndBefore;
import com.example.model.OperationWithPeople;
import com.example.model.People;
import com.example.repository.PeopleRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public People operationInLocalDate(OperationWithPeople operation) {
        People people = repo.findById(operation.getId()).get();
        LocalDate date = null;
        switch (operation.getOperation()){
            case ("minusMonths"):
                date = people.getLocalDate().minusMonths(operation.getNumber());
                break;
            case ("plusMonths"):
                date = people.getLocalDate().plusMonths(operation.getNumber());
                break;
            case ("minusDays"):
                date = people.getLocalDate().minusDays(operation.getNumber());
                break;
            case ("plusDays"):
                date = people.getLocalDate().plusDays(operation.getNumber());
                break;
            case ("minusYears"):
                date = people.getLocalDate().minusYears(operation.getNumber());
                break;
            case ("plusYears"):
                date = people.getLocalDate().plusYears(operation.getNumber());
                break;
        }
        people.setLocalDate(date);
        return repo.save(people);
    }

    public People operationInLocalTime(OperationWithPeople operation){
        People people = repo.findById(operation.getId()).get();
        LocalTime localTime = null;
        switch (operation.getOperation()){
            case ("plusHours"):
                localTime = people.getLocalTime().plusHours(operation.getNumber());
                break;
            case ("minusHours"):
                localTime = people.getLocalTime().minusHours(operation.getNumber());
                break;
            case ("plusMinutes"):
                localTime = people.getLocalTime().plusMinutes(operation.getNumber());
                break;
            case ("minusMinutes"):
                localTime = people.getLocalTime().minusMinutes(operation.getNumber());
                break;
            case ("plusSeconds"):
                localTime = people.getLocalTime().plusSeconds(operation.getNumber());
                break;
            case ("minusSeconds"):
                localTime = people.getLocalTime().minusSeconds(operation.getNumber());
                break;
        }
        people.setLocalTime(localTime);
        return repo.save(people);
    }
    public People operationInLocalDateTime(OperationWithPeople operation){
        People people = repo.findById(operation.getId()).get();
        LocalDateTime localDateTime = null;
        switch (operation.getOperation()){
            case ("minusMonths"):
                localDateTime = people.getLocalDateTime().minusMonths(operation.getNumber());
                break;
            case ("plusMonths"):
                localDateTime = people.getLocalDateTime().plusMonths(operation.getNumber());
                break;
            case ("minusDays"):
                localDateTime = people.getLocalDateTime().minusDays(operation.getNumber());
                break;
            case ("plusDays"):
                localDateTime = people.getLocalDateTime().plusDays(operation.getNumber());
                break;
            case ("minusYears"):
                localDateTime = people.getLocalDateTime().minusYears(operation.getNumber());
                break;
            case ("plusYears"):
                localDateTime = people.getLocalDateTime().plusYears(operation.getNumber());
                break;
            case ("plusHours"):
                localDateTime = people.getLocalDateTime().plusHours(operation.getNumber());
                break;
            case ("minusHours"):
                localDateTime = people.getLocalDateTime().minusHours(operation.getNumber());
                break;
            case ("plusMinutes"):
                localDateTime = people.getLocalDateTime().plusMinutes(operation.getNumber());
                break;
            case ("minusMinutes"):
                localDateTime = people.getLocalDateTime().minusMinutes(operation.getNumber());
                break;
            case ("plusSeconds"):
                localDateTime = people.getLocalDateTime().plusSeconds(operation.getNumber());
                break;
            case ("minusSeconds"):
                localDateTime = people.getLocalDateTime().minusSeconds(operation.getNumber());
                break;
        }
        people.setLocalDateTime(localDateTime);
        return repo.save(people);
    }

    public People updateLocalTime(LocalTime localTime, Long id) {
        People people = repo.findById(id).get();
        LocalTime time = people.getLocalTime().with(localTime);
        people.setLocalTime(time);
        return repo.save(people);
    }

    public People updateLocalDate(LocalDate localDate, Long id) {
        People people = repo.findById(id).get();
        LocalDate date = people.getLocalDate().with(localDate);
        people.setLocalDate(date);
        return repo.save(people);
    }

    public People updateLocalDateTime(LocalDateTime localDateTime, Long id) {
        People people = repo.findById(id).get();
        LocalDateTime date = people.getLocalDateTime().with(localDateTime);
        people.setLocalDateTime(date);
        return repo.save(people);
    }

    public Page<People> findPeopleByName(String name, Pageable pageable) {
        return repo.findPeopleByName(name,pageable);
    }

}
