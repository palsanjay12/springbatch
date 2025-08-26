package com.example.batch.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@EnableScheduling
public class BatchJobScheduler {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobExplorer jobExplorer;
    @Autowired
    private Job myJob;

    @Scheduled(cron = "0 0/20 * * * ?")  // every 2 minutes
    public void runJob() throws Exception {
        String jobName = myJob.getName();

        // Check if job is already running
        List<JobInstance> jobInstances = jobExplorer.findJobInstancesByJobName(jobName, 0, 1);
        if (!jobInstances.isEmpty()) {
            JobInstance lastInstance = jobInstances.get(0);
            List<JobExecution> executions = jobExplorer.getJobExecutions(lastInstance);

            for (JobExecution execution : executions) {
                if (execution.isRunning()) {
                    log.info("⚠️ Job is still running, skipping this schedule...");
                    return; // Skip launch
                }
            }
        }
        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis()) // unique
                .addLong("run.id",System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(myJob, params);
        log.info("✅ Job started at: " + System.currentTimeMillis());
    }
}
