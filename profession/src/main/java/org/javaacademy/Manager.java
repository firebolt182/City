package org.javaacademy;

import lombok.Getter;

@Getter
public class Manager extends Employee{
    private int hourlyRate = 10_000;

    public Manager(String name, String middleName, String lastName, Boolean isMale) {
        super(name, middleName, lastName, isMale);
    }
}