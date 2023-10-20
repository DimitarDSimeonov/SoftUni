package com.plannerapp.controller;


import com.plannerapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if(httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("assignTask", taskService.getAssignedTask());
        model.addAttribute("availableTask", taskService.getAvailableTask());

        return "home";
    }
}
