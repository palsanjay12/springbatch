package com.example.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BatchCsvProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchCsvProcessorApplication.class, args);
	}

}
