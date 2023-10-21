package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private LanguageName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language")
    private List<Word> words;

    public Language() {
    }

    public Language(LanguageName name) {
        this.name = name;
    }

    public LanguageName getName() {
        return name;
    }

    public void setName(LanguageName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
