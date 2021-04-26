package com.example.controller;

import com.example.model.DateAfterAndBefore;
import com.example.model.OperationWithPeople;
import com.example.model.People;
import com.example.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class DateTimeController {
    PeopleService service;

    @GetMapping("/findAll")
    public List<People> findAll(){
        return service.findAll();
    }
    @PostMapping("/create")
    public People createByData(@RequestBody People people){
        return service.createByData(people);
    }

    @PostMapping("/post_local_data/operation_with_people")
    public People operation(@RequestBody OperationWithPeople operation){
        return service.operationInLocalDate(operation);
    }
    @PostMapping("/post_local_time/operation_with_people")
    public People operationInLocalTime(@RequestBody OperationWithPeople operation){
        return service.operationInLocalTime(operation);
    }
    @PostMapping("/post_local_date_time/operation_with_people")
    public People operationInLocalDateTime(@RequestBody OperationWithPeople operation){
        return service.operationInLocalDateTime(operation);
    }

    @PostMapping("/post_local_data/after_befor")
    public List<People> findPeopleByLocalDateBetween(@RequestBody DateAfterAndBefore data){
        LocalDate localDate = data.getAfter().minusMonths(5);
        data.setAfter(localDate);
        return service.findPeopleByLocalDateBetween(data);
    }

    @PostMapping("/post_local_data/after")
    public List<People> findPeopleByLocalDateAfter(@RequestBody LocalDate after){
        return service.findPeopleByLocalDateAfter(after);
    }
    @PostMapping("/post_local_data/befor")
    public List<People> findPeopleByLocalDateBefore(@RequestBody LocalDate before){
        return service.findPeopleByLocalDateBefore(before);
    }
    @PutMapping("/local_time/{id}")
    public People updateLocalTime(@RequestBody LocalTime localTime, @PathVariable Long id){
        return service.updateLocalTime(localTime,id);
    }
    @PutMapping("/local_date/{id}")
    public People updateLocalDate(@RequestBody LocalDate localDate, @PathVariable Long id){
        return service.updateLocalDate(localDate,id);
    }

    @GetMapping("/name/{name}")
    public List<People> getActorByName(@PathVariable String name,
                                       @RequestParam(name = "size", required = false, defaultValue = "1") int pageSize,
                                       @RequestParam(name = "page", required = false, defaultValue = "5") int pageNumber){

        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable= PageRequest.of(pageSize, pageNumber, sort);
        Page<People> people = service.findPeopleByName(name, pageable);
        return people.getContent();
    }
}