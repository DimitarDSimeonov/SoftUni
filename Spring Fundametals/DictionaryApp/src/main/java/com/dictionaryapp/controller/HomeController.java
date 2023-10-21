package com.dictionaryapp.controller;

import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.service.WordService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final WordService wordService;

    public HomeController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("spanishWords",wordService.getByLanguage(LanguageName.SPANISH));
        model.addAttribute("germanWords",wordService.getByLanguage(LanguageName.GERMAN));
        model.addAttribute("frenchWords",wordService.getByLanguage(LanguageName.FRENCH));
        model.addAttribute("italianWords",wordService.getByLanguage(LanguageName.ITALIAN));
        model.addAttribute("allWords", wordService.getAll());

        return "home";
    }

    @GetMapping("home/remove-all")
    public String removeAll() {

        wordService.removeAll();
        return "redirect:/";
    }
}
