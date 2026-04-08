package com.scheduling.dynamic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduling.dynamic.dto.SchedulingRequest;
import com.scheduling.dynamic.model.Job;
import com.scheduling.dynamic.service.JobService;


@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping
    public Job create(@RequestBody SchedulingRequest job) {
        return service.createJob(job);
    }

    @PostMapping("/{id}/stop")
    public String stop(@PathVariable Long id) {
        service.stop(id);
        return "Stopped";
    }

    @PutMapping("/update")
    public Job updateJob(@RequestBody SchedulingRequest updatedJob) {
        return service.update(updatedJob);
    }
}