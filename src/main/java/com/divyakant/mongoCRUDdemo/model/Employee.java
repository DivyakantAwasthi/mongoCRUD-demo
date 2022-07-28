package com.divyakant.mongoCRUDdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employees")
public class Employee {

    @Id
    private int id;
    private String name;
    private String department;
    private String gender;
    private String phoneNumber;
    @JsonProperty("Address")
    private Address address;
}
