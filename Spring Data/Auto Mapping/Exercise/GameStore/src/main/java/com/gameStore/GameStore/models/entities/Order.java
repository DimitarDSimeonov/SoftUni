package com.gameStore.GameStore.models.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @ManyToOne
    private User user;

    @ManyToMany(targetEntity = Game.class, fetch = FetchType.EAGER)
    private Set<Game> games;
}
