package com.gameStore.GameStore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "games")
public class Game extends BaseEntity{

    @Column
    private String title;

    @Column
    private String trailer;

    @Column(name = "image_thumbnail")
    private String imageThumbnail;

    @Column
    private Double size;

    @Column
    private BigDecimal price;

    @Column
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;
}
