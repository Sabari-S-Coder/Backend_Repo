package com.scheduling.dynamic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduling.dynamic.dto.SchedulingRequest;
import com.scheduling.dynamic.model.Job;
import com.scheduling.dynamic.repo.ScheduledJobsRepo;
import com.scheduling.dynamic.scheduler.DynamicTaskSchedulerService;

@Service
public class JobService {

    @Autowired
    private ScheduledJobsRepo scheduledJobsRepo;

    @Autowired
    private DynamicTaskSchedulerService dynamicScheduler;


    public Job createJob(SchedulingRequest request) {
        Job job = new Job();
        job.setTaskName(request.getTaskName());
        job.setCronExpression(request.getCronExpression());
        job.setIsactive(true);
        Job savedJob = scheduledJobsRepo.save(job);
        if(savedJob.isIsactive()){
            dynamicScheduler.scheduleTask(savedJob);
        }
        return savedJob;
    }


    public void stop(Long id) {
        dynamicScheduler.stopTask(id);

        Job job = scheduledJobsRepo.findById(id).orElseThrow();
        job.setIsactive(false);
        scheduledJobsRepo.save(job);
    }

    public Job update(SchedulingRequest updatedJob) {

    Job existing = scheduledJobsRepo.findByTaskName(updatedJob.getTaskName()).orElseThrow();

    // 1. Stop existing scheduled job
    dynamicScheduler.stopTask(existing.getId());

    // 2. Update values
    
    existing.setTaskName(updatedJob.getTaskName());
    existing.setIsactive(updatedJob.isIsactive());
    existing.setCronExpression(updatedJob.getCronExpression());

    Job saved = scheduledJobsRepo.save(existing);

    // 3. Reschedule if active
    if (saved.isIsactive()) {
        dynamicScheduler.scheduleTask(saved);
    }

    return saved;
}
}
