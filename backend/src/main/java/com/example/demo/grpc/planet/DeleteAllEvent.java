package com.example.demo.grpc.planet;

import com.example.demo.grpc.planet.InitEvent.Reason;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class DeleteAllEvent extends ApplicationEvent {

    private Reason description;

    public DeleteAllEvent(Object source) {
        super(source);
        this.description = Reason.DELETE_ALL;
    }
}
