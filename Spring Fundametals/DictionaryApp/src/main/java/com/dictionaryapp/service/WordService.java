package com.dictionaryapp.service;

import com.dictionaryapp.model.WordViewModel;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.model.service.WordAddServiceModel;

import java.util.List;

public interface WordService {
    void add(WordAddServiceModel wordAddServiceModel);

    List<WordViewModel> getByLanguage(LanguageName languageName);

    Long getAll();

    void removeAll();

    void removeById(Long id);
}
