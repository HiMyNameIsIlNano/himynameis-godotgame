package com.example.demo.domain.planet.listener;

import com.example.demo.grpc.game.planet.DeleteAllEvent;
import com.example.demo.grpc.game.planet.DeleteOneEvent;
import com.example.demo.grpc.game.planet.InitEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class UniverseEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterInitEvent(InitEvent initEvent) {
        // TODO: persist the event into the DB logging table
        log.info("Event type {}", initEvent.getDescription());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterDeleteOne(DeleteOneEvent deleteOneEvent) {
        // TODO: persist the event into the DB logging table
        log.info("Event type {}", deleteOneEvent.getDescription());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterDeleteAll(DeleteAllEvent deleteAllEvent) {
        // TODO: persist the event into the DB logging table
        log.info("Event type {}", deleteAllEvent.getDescription());
    }
}
