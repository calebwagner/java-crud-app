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

    // Constructor with id for testing purposes
    public Course(Integer id, String name, long length, String url, Optional<String> notes) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.url = url;
        this.notes = notes.orElse(null);
    }

    private Course(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.length = builder.length;
        this.url = builder.url;
        this.notes = builder.notes.orElse(null);
    }

    public static class Builder {
        private Integer id;
        private String name;
        private long length;
        private String url;
        private Optional<String> notes = Optional.empty();

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder length(long length) {
            this.length = length;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder notes(Optional<String> notes) {
            this.notes = notes;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
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