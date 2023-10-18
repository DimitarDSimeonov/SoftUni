package com.plannerapp.model.entity;

import com.plannerapp.model.entity.enums.PriorityName;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "priorities")
public class Priority {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated (EnumType.STRING)
    private PriorityName name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "priority")
    private List<Task> tasks;


    public Priority() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PriorityName getName() {
        return name;
    }

    public void setName(PriorityName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDescription() {
        switch (this.name) {
            case LOW -> this.description = "Should be fixed if time permits but can be postponed.";
            case IMPORTANT -> this.description = "A core functionality that your product is explicitly supposed to perform is compromised";
            case URGENT -> this.description = "An urgent problem that blocks the system use until the issue is resolved.";
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
