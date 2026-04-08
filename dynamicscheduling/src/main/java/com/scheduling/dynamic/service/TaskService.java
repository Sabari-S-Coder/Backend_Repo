package com.scheduling.dynamic.service;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public void executeTask() {
        System.out.println("Executing task: ");
        System.out.println("Task executed successfully!");
        System.out.println();
    }

}
