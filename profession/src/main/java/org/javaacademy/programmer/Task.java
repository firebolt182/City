package org.javaacademy.programmer;

import lombok.Setter;

@Setter
public class Task {

    private String description;
    private boolean isDone = false;
    private int timeCosts;

    protected Task(String description, int timeCosts) {
        this.description = description;
        this.timeCosts = timeCosts;
    }
}