package com.cobacha.libro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    private String name;
    private int birth_year;
    private int death_year;
    // ... otros atributos

    // Constructor, getters y setters

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birth_year=" + birth_year +
                ", death_year=" + death_year +
                '}';
    }
}
