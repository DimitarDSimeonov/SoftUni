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

    public User() {}

    public User(String email, String password, String fullName, Boolean isAdministrator, Set<Game> games, Set<Order> orders) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.isAdministrator = isAdministrator;
        this.games = games;
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(Boolean administrator) {
        isAdministrator = administrator;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
