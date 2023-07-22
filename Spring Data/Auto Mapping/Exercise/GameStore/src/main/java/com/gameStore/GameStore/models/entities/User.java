package com.gameStore.GameStore.models.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "is_administrator")
    private Boolean isAdministrator;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Game> games;

    @OneToMany(targetEntity = Order.class,mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Order> orders;
}
