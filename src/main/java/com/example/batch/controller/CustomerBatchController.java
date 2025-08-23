//package com.example.batch.controller;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.explore.JobExplorer;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1")
//@RequiredArgsConstructor
//public class CustomerBatchController {
//    private final JobLauncher jobLauncher;
//    private final Job importCustomerJob;
//    private final JobExplorer jobExplorer;
//
//    //    private final JobRunner jobRunner;
//    @GetMapping("/processCustomer")
//    public ResponseEntity<String> handle() throws Exception {
//
//        // simulate the user uploading a CSV file of contacts to this controller endpoint
////        ClassPathResource imgFile = new ClassPathResource("customers-100.csv");
////        String pathToResource = imgFile.getFile().getAbsolutePath();
////
//        JobParameters params = new JobParametersBuilder()
//                .addString("JobID", String.valueOf(System.currentTimeMillis()))
//                .toJobParameters();
//        jobLauncher.run(importCustomerJob, params);
////        jobRunner.run(null);
//        return ResponseEntity.ok().body("Batch job has been invoked");
//    }
//}
