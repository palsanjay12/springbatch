package com.example.batch.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class MyWriter implements ItemWriter<String> {


    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {
        log.info("**** MyWriter ***");

        System.out.println(">> Writing chunk: " + chunk);

    }
}
