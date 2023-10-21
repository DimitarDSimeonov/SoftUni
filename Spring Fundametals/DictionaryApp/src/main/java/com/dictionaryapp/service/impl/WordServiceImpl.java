package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.WordViewModel;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.model.service.WordAddServiceModel;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.LanguageService;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final ModelMapper modelMapper;
    private final LanguageService languageService;
    private final UserService userService;

    public WordServiceImpl(WordRepository wordRepository, ModelMapper modelMapper, LanguageService languageService, UserService userService) {
        this.wordRepository = wordRepository;
        this.modelMapper = modelMapper;
        this.languageService = languageService;
        this.userService = userService;
    }

    @Override
    public void add(WordAddServiceModel wordAddServiceModel) {

        Word word = modelMapper.map(wordAddServiceModel, Word.class);

        word.setLanguage(languageService.getByName(wordAddServiceModel.getLanguage()));
        word.setAddedBy(userService.getLoggedUser());

        wordRepository.save(word);
    }

    @Override
    public List<WordViewModel> getByLanguage(LanguageName languageName) {

        return wordRepository.findAllByLanguage_Name(languageName)
                .stream()
                .map(word -> {
                    WordViewModel wordViewModel = new WordViewModel();
                    wordViewModel.setId(word.getId());
                    wordViewModel.setTerm(word.getTerm());
                    wordViewModel.setTranslation(word.getTranslation());
                    wordViewModel.setExample(word.getExample());
                    wordViewModel.setUsername(word.getAddedBy().getUsername());
                    wordViewModel.setInputDate(word.getInputDate());
                    return wordViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Long getAll() {
        return wordRepository.count();
    }

    @Override
    public void removeAll() {
        wordRepository.deleteAll();
    }

    @Override
    public void removeById(Long id) {
        wordRepository.deleteById(id);
    }
}
