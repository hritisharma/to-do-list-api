package com.hritik.to_do.list.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @SequenceGenerator(name = "seq_gen",sequenceName = "seq_gen" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq_gen")
    private Long id;
    private String title;
    private String description;
    private String status = "pending";

    public Task() {
    }

    public Task(Long id, String status, String description, String title) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
