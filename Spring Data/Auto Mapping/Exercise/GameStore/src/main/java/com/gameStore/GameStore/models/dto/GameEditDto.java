package com.gameStore.GameStore.models.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class GameEditDto {
    private Long id;

    private String title;

    private BigDecimal price;

    private Double size;

    private String trailer;

    private String imageThumbnail;

    private String description;

    private LocalDate releaseDate;

    public GameEditDto() {}

    public GameEditDto(Long id, String title, BigDecimal price, Double size, String trailer, String imageThumbnail, String description, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void editFields(Map<String, String> editFields) {
        for (String key : editFields.keySet()) {

            switch (key) {
                case "title" -> setTitle(editFields.get(key));
                case "price" -> setPrice(new BigDecimal(editFields.get(key)));
                case "size" -> setSize(Double.parseDouble(editFields.get(key)));
                case "trailer" -> setTrailer(editFields.get(key));
                case "thumbnailURL" -> setImageThumbnail(editFields.get(key));
                case "description" -> setDescription(editFields.get(key));
                case "releaseDate" -> setReleaseDate(LocalDate.parse(editFields.get(key), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
        }
    }
}
