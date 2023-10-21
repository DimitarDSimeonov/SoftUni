package com.dictionaryapp.controller;

import com.dictionaryapp.model.binding.WordAddBindingModel;
import com.dictionaryapp.model.service.WordAddServiceModel;
import com.dictionaryapp.service.WordService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;
    private final ModelMapper modelMapper;

    public WordController(WordService wordService, ModelMapper modelMapper) {
        this.wordService = wordService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (!model.containsAttribute("wordAddBindingModel")) {
            model.addAttribute("wordAddBindingModel", new WordAddBindingModel());
        }

        return "word-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid WordAddBindingModel wordAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("wordAddBindingModel", wordAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.wordAddBindingModel", bindingResult);
            return "redirect:add";
        }

        wordService.add(modelMapper.map(wordAddBindingModel, WordAddServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeById(@PathVariable Long id) {

        wordService.removeById(id);

        return "redirect:/";
    }
}
