package com.crud.app.model;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "COURSES")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private long length;
    private String url;
    private String notes;

    // Default constructor required by JPA
    public Course() {}

    public Course(String name, long length, String url, Optional<String> notes) {
        this.name = name;
        this.length = length;
        this.url = url;
        this.notes = notes.orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}