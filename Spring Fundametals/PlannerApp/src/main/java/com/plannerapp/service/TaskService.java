package com.plannerapp.service;

import com.plannerapp.model.binding.TaskAddBindingModel;

public interface TaskService {
    void add(TaskAddBindingModel taskAddBindingModel);

    void assign(Long id);
}
