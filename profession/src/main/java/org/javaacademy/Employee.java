package org.javaacademy;

public class Employee extends Human{
    private int hourlyRate;

    public Employee(String name, String middleName, String lastName, Sex sex) {
        super(name, middleName, lastName, sex);
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}