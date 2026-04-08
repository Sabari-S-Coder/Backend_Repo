package com.scheduling.dynamic.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduling.dynamic.model.Job;

public interface ScheduledJobsRepo extends JpaRepository<Job, Long> {
    Optional<Job> findByTaskName(String taskName);

}
