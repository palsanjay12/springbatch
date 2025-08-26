package com.example.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ItemProcessorLoggingListener implements
        ItemProcessListener<String, String>
         {
    @Override
    public void beforeProcess(String item) {
        log.info("➡️ItemProcessorLoggingListener  Processing item: {}", item);
    }

    @Override
    public void afterProcess(String item, String result) {
        log.info("✅ ItemProcessorLoggingListener Processed item: {} -> {}", item, result);
        // auditRepository.save(new AuditLog("PROCESSED", result));
    }

    @Override
    public void onProcessError(String item, Exception e) {
        log.error("❌ItemProcessorLoggingListener  Error processing item: {}", item, e);
    }

}
