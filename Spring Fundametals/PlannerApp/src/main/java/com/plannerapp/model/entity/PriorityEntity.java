package com.plannerapp.model.entity;

import com.plannerapp.model.entity.enums.PriorityName;

import javax.persistence.*;

@Entity
@Table(name = "priorities")
public class PriorityEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated (EnumType.STRING)
    private PriorityName name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    //ToDo ...
}
