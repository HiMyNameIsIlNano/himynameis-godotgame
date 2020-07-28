package com.example.demo.grpc.recipe;

import com.example.demo.grpc.recipe.InitEvent.Reason;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class DeleteOneEvent extends ApplicationEvent {

    private Reason description;

    public DeleteOneEvent(Object source) {
        super(source);
        this.description = Reason.DELETE_ONE;
    }
}
