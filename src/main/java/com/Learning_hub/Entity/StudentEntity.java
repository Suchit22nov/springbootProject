package com.Learning_hub.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class StudentEntity {
    @Id
    private long id;

    private String name;
    private String work;
    private LocalDateTime date;
}
