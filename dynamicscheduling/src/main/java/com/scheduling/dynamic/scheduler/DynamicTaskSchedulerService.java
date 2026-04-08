package com.scheduling.dynamic.scheduler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.scheduling.dynamic.model.Job;

@Service
public class DynamicTaskSchedulerService {
    
    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    private JobLogRegistry registry;

    private Map<Long, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();

    public void scheduleTask(Job request) {
        Runnable task = () ->{
            Runnable actualJob =registry.getJob(request.getTaskName());
            if(actualJob != null) {
                actualJob.run();
            }else{
                System.out.println("No job found with name: " + request.getTaskName());
            }
        };

        ScheduledFuture<?> future = taskScheduler.schedule(task, new CronTrigger(request.getCronExpression()));
        scheduledTasks.put(request.getId(), future);
    }

    public void stopTask(Long id) {
        ScheduledFuture<?> future = scheduledTasks.get(id);
        if (future != null) {
            future.cancel(false);
            scheduledTasks.remove(id);
        }
    }
    
}
