package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")   //  "localDate": "2021-04-24"
    @Column(name = "LocalDate", columnDefinition = "DATE")
    private LocalDate localDate;

    @JsonFormat(pattern = "HH:mm:ss") //  "localTime": [10,10,10]
    @Column(name = "localTime", columnDefinition = "TIME")
    private LocalTime localTime ;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //  "localDateTime": "2012-12-17 12:12:17"
    @Column(name = "localDateTime", columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

}
