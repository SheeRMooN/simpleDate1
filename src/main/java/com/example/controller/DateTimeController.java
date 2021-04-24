package com.example.controller;

import com.example.model.DateAfterAndBefore;
import com.example.model.People;
import com.example.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/get_local_data/after_befor")
    public List<People> findPeopleByLocalDateBetween(@RequestBody DateAfterAndBefore data){
        return service.findPeopleByLocalDateBetween(data);
    }
    @GetMapping("/get_local_data/after")
    public List<People> findPeopleByLocalDateAfter(@RequestBody LocalDate after){
        return service.findPeopleByLocalDateAfter(after);
    }
    @GetMapping("/get_local_data/befor")
    public List<People> findPeopleByLocalDateBefore(@RequestBody LocalDate before){
        return service.findPeopleByLocalDateBefore(before);
    }
}