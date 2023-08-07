package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VideoEntity {
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;

    protected VideoEntity() {
        this.name = this.description = null;
    }

    public VideoEntity(String _Name, String _Description) {
        this.name = _Name;
        this.description = _Description;
        this.id = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long _Id) {
        this.id = _Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String _Name) {
        this.name = _Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String _Description) {
        this.description = _Description;
    }
}