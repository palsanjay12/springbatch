package com.example.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ItemWriterLoggingListener implements

        ItemWriteListener<String> {

    @Override
    public void beforeWrite(Chunk<? extends String> items) {
        log.info("➡️ Writing items: {}", items);
    }

    @Override
    public void afterWrite(Chunk<? extends String> items) {
        log.info("✅ItemWriterLoggingListener   Written items: {}", items);
        // batch insert into DB
        // auditRepository.saveAll(items.stream().map(i -> new AuditLog("WRITTEN", i)).toList());
    }

    @Override
    public void onWriteError(Exception exception, Chunk<? extends String> items) {
        log.error("❌ ItemWriterLoggingListener Error writing items: {}", items, exception);
    }
}
