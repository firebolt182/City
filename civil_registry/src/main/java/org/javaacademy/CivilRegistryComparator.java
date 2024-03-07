package org.javaacademy;

import java.util.Comparator;

public class CivilRegistryComparator implements Comparator<CitizenActionRecord> {

    @Override
    public int compare(CitizenActionRecord action1, CitizenActionRecord action2) {
        return action1.getDate().compareTo(action2.getDate());
    }
}