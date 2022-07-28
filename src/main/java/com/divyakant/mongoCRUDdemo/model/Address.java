package com.divyakant.mongoCRUDdemo.model;

import lombok.Data;

@Data
public class Address {
    private String city;
    private String zip;
    private String state;
    private String country;
}
