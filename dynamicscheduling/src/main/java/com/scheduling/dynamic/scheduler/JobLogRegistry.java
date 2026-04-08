package com.scheduling.dynamic.scheduler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduling.dynamic.service.TaskService;

import jakarta.annotation.PostConstruct;

@Component
public class JobLogRegistry {

    @Autowired
    private TaskService taskService;

    private Map<String, Runnable> jobs = new HashMap<>();

    @PostConstruct
    public void init() {
        jobs.put("Process-1", () -> taskService.executeTask());
    }

    public Runnable getJob(String name) {
        return jobs.get(name);
    }

}
