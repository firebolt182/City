package org.javaacademy;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.javaacademy.programmer.Programmer;
import org.javaacademy.programmer.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class Company {

    private String name;
    private Manager manager;
    private List<Programmer> programmersList;
    private MultiValuedMap<Programmer, Task> completedTasks = new HashSetValuedHashMap<>();
    private Map<Employee, Integer> reportCard = new HashMap<>();
    private double costs;

    public Company(String name, Manager manager, List<Programmer> programmersList, int programmerHourlyRate) {
        this.name = name;
        this.manager = manager;
        this.programmersList = programmersList;
        programmersList.forEach(programmer -> programmer.setHourlyRate(programmerHourlyRate));
    }
}
