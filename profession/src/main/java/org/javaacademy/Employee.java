package org.javaacademy;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee extends Human{
    private int hourlyRate;

    public Employee(String name, String middleName, String lastName, Sex sex) {
        super(name, middleName, lastName, sex);
    }
}