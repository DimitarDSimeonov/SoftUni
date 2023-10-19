package com.plannerapp.model.service;

import com.plannerapp.model.view.TaskViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserLoginServiceModel {

    private Long id;
    private String username;
    private String password;
    private List<TaskViewModel> assignedTask;
    private List<TaskViewModel> availableTask;

    public UserLoginServiceModel() {
        assignedTask = new ArrayList<>();
        availableTask = new ArrayList<>();
    }

    public UserLoginServiceModel(List<TaskViewModel> assignedTask, List<TaskViewModel> availableTask) {
        this.assignedTask = assignedTask;
        this.availableTask = availableTask;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TaskViewModel> getAssignedTask() {
        return assignedTask;
    }

    public void setAssignedTask(List<TaskViewModel> assignedTask) {
        this.assignedTask = assignedTask;
    }

    public List<TaskViewModel> getAvailableTask() {
        return availableTask;
    }

    public void setAvailableTask(List<TaskViewModel> availableTask) {
        this.availableTask = availableTask;
    }
}
