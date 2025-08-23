package com.example.batch.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String item) {
        // Transform: capitalize the name
        log.info("**** MyProcessor ***");
        return item.toUpperCase();
    }
}
