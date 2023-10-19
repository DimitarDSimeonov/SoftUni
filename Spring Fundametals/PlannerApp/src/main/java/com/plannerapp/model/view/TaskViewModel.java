package com.plannerapp.model.view;

import com.plannerapp.model.entity.enums.PriorityName;

import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String priority;
    private String description;
    private LocalDate dueDate;

    public TaskViewModel() {
    }

    public TaskViewModel(Long id, String priority, String description, LocalDate dueDate) {
        this.id = id;
        this.priority = priority;
        this.description = description;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
