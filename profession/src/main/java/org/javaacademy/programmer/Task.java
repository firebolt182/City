package org.javaacademy.programmer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Task {

    private String description;
    private boolean isDone;
    private double timeCosts;

    public Task(String description, int timeCosts) {
        this.description = description;
        this.timeCosts = timeCosts;
    }

    @Override
    public String toString() {
        return description;
    }
}