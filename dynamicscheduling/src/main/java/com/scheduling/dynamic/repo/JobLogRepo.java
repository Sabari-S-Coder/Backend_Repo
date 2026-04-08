package com.scheduling.dynamic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduling.dynamic.model.JobLog;

public interface JobLogRepo extends JpaRepository<JobLog, Long>  {

}
