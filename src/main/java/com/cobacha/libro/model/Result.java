package com.cobacha.libro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private int id;
    private String title;
    private List<Author> authors;
    // ... otros atributos

    // Constructor, getters y setters

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                '}';
    }
}