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

//    @JsonFormat(pattern = "yyyy-MM-dd") //  "date": "2021-04-24"
//    @Column(name = "date", columnDefinition = "DATE")
//    private Date date;


//    @Column(name = "LocalDate", columnDefinition = "DATE")
//    @JsonFormat(pattern = "yyyy-MM-dd")   //  "localTime": [10,10,10]
    private LocalDate localDate;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //  "localDateTime": "2012-12-17 12:12:17"
//    @Column(name = "localDateTime", columnDefinition = "TIMESTAMP")
//    private LocalDateTime localDateTime;

//    {
//        "date": "2021-04-24",
//        "localDateTime": "2012-12-17 12:12:17",
//         "localTime": [10,10,10],
//        "name": "string"
//    }
}
