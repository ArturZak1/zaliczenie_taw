package com.example.courses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class Course {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nazwa")
    private String name;
    @JsonProperty("ects")
    private int points;
    @JsonProperty("numerSali")
    private int roomNumber;
    @JsonProperty("egzamin")
    private boolean exam;
}
