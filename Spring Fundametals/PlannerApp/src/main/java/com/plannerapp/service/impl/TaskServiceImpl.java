package com.plannerapp.service.impl;

import com.plannerapp.model.binding.TaskAddBindingModel;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.view.TaskViewModel;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.service.PriorityService;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final PriorityService priorityService;
    private final UserService userService;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, PriorityService priorityService, UserService userService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.priorityService = priorityService;
        this.userService = userService;
    }

    @Override
    public void add(TaskAddBindingModel taskAddBindingModel) {

        Task task = modelMapper.map(taskAddBindingModel, Task.class);

        task.setPriority(priorityService.getByName(taskAddBindingModel.getPriority()));

        taskRepository.save(task);

    }

    @Override
    public void assign(Long id) {
        Task task = taskRepository.findById(id).get();

        task.setUser(userService.getLoggedUser());

        taskRepository.saveAndFlush(task);
    }

    @Override
    public List<TaskViewModel> getAvailableTask() {
        return taskRepository.findAllAvailable()
                .stream()
                .map(task -> {
            TaskViewModel taskViewModel = new TaskViewModel(task.getId(),task.getPriority().getName().name(), task.getDescription(), task.getDueDate());
            return taskViewModel;
        })
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskViewModel> getAssignedTask() {
        return taskRepository.findByUser_Id(userService.getLoggedUser().getId())
                .stream()
                .map(task -> {
                    TaskViewModel taskViewModel = new TaskViewModel(task.getId(),task.getPriority().getName().name(), task.getDescription(), task.getDueDate());
                    return taskViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void returnTask(Long id) {
        Task task = taskRepository.findById(id).get();

        task.setUser(null);

        taskRepository.save(task);
    }
}
