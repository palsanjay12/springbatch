package com.example.batch.job;

import com.example.batch.listener.*;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class CustomerJobConfig {
    private final EntityManagerFactory entityManagerFactory;
    private final LoggingStepListener loggingStepListener;
    private final ItemReaderLoggingListener readerLoggingListener;
    private final ItemWriterLoggingListener writerLoggingListener;
    private final ItemProcessorLoggingListener processorLoggingListener;
    @Bean
    public JobCompletionNotificationListener jobCompletionNotificationListener() {
        return new JobCompletionNotificationListener();
    }

    @Bean
    public Job myJob(Step myStep, JobRepository jobRepository) {
        return new JobBuilder("myJob", jobRepository)
                .start(myStep)
                .listener(jobCompletionNotificationListener())
                .build();
    }

    @Bean
    public Step myStep(JobRepository jobRepository, PlatformTransactionManager transactionManager, ItemReader<String> reader,
                       ItemProcessor<String, String> processor,
                       ItemWriter<String> writer) {
        return new StepBuilder("myStep", jobRepository)
                .<String, String>chunk(1, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(loggingStepListener)
                .listener(readerLoggingListener)
                .listener(writerLoggingListener)
                .listener(processorLoggingListener)
                .build();
    }

}
