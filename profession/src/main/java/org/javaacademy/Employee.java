package org.javaacademy;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee extends Human{
    private int hourlyRate;
    private double amountOfEarnings;

    public Employee(String name, String middleName, String lastName, Boolean isMale) {
        super(name, middleName, lastName, isMale);
    }
}