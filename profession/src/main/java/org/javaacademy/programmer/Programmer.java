package org.javaacademy.programmer;

import org.javaacademy.Employee;
import org.javaacademy.HourlyRateException;

public class Programmer extends Employee {
    public Programmer(String name, String middleName, String lastName, Boolean isMale) {
        super(name, middleName, lastName, isMale);
    }

    public void setProgrammerHourlyRate(int hourlyRate) throws HourlyRateException {
        if (hourlyRate < 1500 || hourlyRate > 2000) {
            throw new HourlyRateException("неверная ставка");
        }
        setHourlyRate(hourlyRate);
    }

    public void takeTask(Task task) {
        task.setDone(true);
    }
}