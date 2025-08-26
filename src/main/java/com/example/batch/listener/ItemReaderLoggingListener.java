package com.example.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ItemReaderLoggingListener implements
        ItemReadListener<String>
      {

    @Override
    public void beforeRead() {
        log.info("➡️ Starting to read an item...");
    }

    @Override
    public void afterRead(String item) {
        log.info("✅ ItemReaderLoggingListener Read item: {}", item);
        // insert into DB audit table
        // auditRepository.save(new AuditLog("READ", item));
    }

    @Override
    public void onReadError(Exception ex) {
        log.error("❌ ItemReaderLoggingListener Error reading item", ex);
    }

}
