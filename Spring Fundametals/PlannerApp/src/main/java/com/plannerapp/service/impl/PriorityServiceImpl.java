package com.plannerapp.service.impl;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.service.PriorityService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void initPriorities() {
        if (priorityRepository.count() == 0) {
            Arrays.stream(PriorityName.values())
                    .forEach(priorityName -> {
                        Priority priority = new Priority();
                        priority.setName(priorityName);
                        priority.setDescription();
                        priorityRepository.save(priority);
                    });
        }
    }
}
