package org.javaacademy;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.javaacademy.programmer.Programmer;
import org.javaacademy.programmer.Task;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
public class Company {

    private String name;
    private Manager manager;
    private List<Programmer> programmersList;
    private MultiValuedMap<Programmer, Task> completedTasks = new HashSetValuedHashMap<>();
    private Map<Employee, Double> reportCard = new HashMap<>();
    private double costs;

    public Company(String name, Manager manager, List<Programmer> programmersList, int programmerHourlyRate) {
        this.name = name;
        this.manager = manager;
        this.programmersList = programmersList;
        programmersList.forEach(programmer -> {
            try {
                programmer.setProgrammerHourlyRate(programmerHourlyRate);
            } catch (HourlyRateException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void weeklyWork(List<Task> taskList) {
        AtomicInteger counter = new AtomicInteger();
        taskList.forEach(task -> taskProcessing(task, counter));
    }

    private void taskProcessing(Task task, AtomicInteger counter) {
        Programmer programmer = programmersList.get(counter.getAndIncrement());
        programmer.takeTask(task);
        System.out.printf("%s - сделана.\n", task.getDescription());
        reportCardProgramerAdd(programmer, task);
        reportCardManagerAdd(this.manager, task);
        completedTasks.put(programmer, task);
        if (counter.get() == programmersList.size()) {
            counter.set(0);
        }
    }

    private void reportCardProgramerAdd(Programmer programmer, Task task) {
        if (reportCard.get(programmer) == null) {
            reportCard.put(programmer, task.getTimeCosts());
        } else {
            reportCard.put(programmer, reportCard.get(programmer) + task.getTimeCosts());
        }
    }

    private void reportCardManagerAdd(Manager manager, Task task) {
        if (reportCard.get(manager) == null) {
            reportCard.put(this.manager, task.getTimeCosts() * 0.1);
        } else {
            reportCard.put(this.manager, reportCard.get(this.manager) + task.getTimeCosts() * 0.1);
        }
    }

    public void weeklyPayment() {
        reportCard.forEach((employee, aDouble) -> employee.setAmountOfEarnings(employee.getHourlyRate() * aDouble));
        reportCard.forEach((employee, aDouble) -> setCosts(costs + employee.getHourlyRate() * aDouble));
        reportCard.clear();
    }
}