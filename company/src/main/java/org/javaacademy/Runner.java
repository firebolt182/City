package org.javaacademy;

import org.javaacademy.programmer.Programmer;
import org.javaacademy.programmer.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Runner {

    public static void main(String[] args) {
        String companyName = "Oracle";
        int programmerHourPayment = Integer.parseInt(args[0]);
                Company company = new Company(companyName,
                new Manager("Ben", "Jackovich", "Ivanov", true),
                List.of(new Programmer("Steve", "Steve", "Spielberg", true),
                        new Programmer("Lara", "Stepanovna", "Croft", false)),
                programmerHourPayment);
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Вымыть руки", 2));
        taskList.add(new Task("Пообедать", 5));
        taskList.add(new Task("Хорошенько выспаться", 10));
        company.weeklyWork(taskList);
        company.weeklyPayment();
        company.companyInfo();
    }
}
