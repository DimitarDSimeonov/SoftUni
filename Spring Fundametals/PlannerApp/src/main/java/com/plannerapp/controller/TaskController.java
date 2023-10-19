package com.plannerapp.controller;

import com.plannerapp.model.binding.TaskAddBindingModel;
import com.plannerapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/add")
    private String add(Model model, HttpSession httpSession) {
        if(httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (!model.containsAttribute("taskAddBindingModel")) {
            model.addAttribute("taskAddBindingModel", new TaskAddBindingModel());
        }
        return "task-add";
    }

    @PostMapping("/add")
    private String addConfirm(@Valid TaskAddBindingModel taskAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);

            return "redirect:add";
        }

        taskService.add(taskAddBindingModel);

        return "redirect:/";
    }

    @GetMapping("/assign/{id}")
    public String assign(@PathVariable Long id) {

        taskService.assign(id);

        return "redirect:/";
    }
}
