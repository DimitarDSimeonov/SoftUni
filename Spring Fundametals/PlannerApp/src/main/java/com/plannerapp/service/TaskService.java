package com.plannerapp.service;

import com.plannerapp.model.binding.TaskAddBindingModel;
import com.plannerapp.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void add(TaskAddBindingModel taskAddBindingModel);

    void assign(Long id);

    List<TaskViewModel> getAvailableTask();

    List<TaskViewModel> getAssignedTask();

    void remove(Long id);

    void returnTask(Long id);
}
