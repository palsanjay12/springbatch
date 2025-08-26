package com.example.batch.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class MyReader implements ItemReader<String> {

    private  Iterator<String> data;
    public MyReader() {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
        log.info("**** MyReader ***");

        this.data = names.iterator();
    }

    @Override
    public String read() {
//        if (data == null || !data.hasNext()) {
//            List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
//            log.info("**** MyReader ***");
//
//            this.data = names.iterator();
//        }
        return data.hasNext() ? data.next() : null;
    }
}
