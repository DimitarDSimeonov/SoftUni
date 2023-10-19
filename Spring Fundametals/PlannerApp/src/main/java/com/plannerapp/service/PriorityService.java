package com.plannerapp.service;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.enums.PriorityName;

public interface PriorityService {
    void initPriorities();

    Priority getByName(PriorityName name);

}
