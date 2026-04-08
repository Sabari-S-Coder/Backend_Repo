package com.scheduling.dynamic.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduling.dynamic.repo.ScheduledJobsRepo;

import jakarta.annotation.PostConstruct;

@Component
public class JobLoader {

    @Autowired
    private ScheduledJobsRepo repo;

    @Autowired
    private DynamicTaskSchedulerService scheduler;

    @PostConstruct
    public void load() {
        repo.findAll().forEach(job -> {
            if (job.isIsactive()) {
                scheduler.scheduleTask(job);
            }
        });
    }
}
