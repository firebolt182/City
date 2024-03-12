package org.javaacademy;

public class Manager extends Employee{
    private final int MANAGER_RATE = 10_000;

    public Manager(String name, String middleName, String lastName, Sex sex) {
        super(name, middleName, lastName, sex);
    }
}