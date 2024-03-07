package org.javaacademy;

import java.time.LocalDate;

public class RunnerProm {
    public static void main(String[] args) {
        CivilRegistry civilRegistry = new CivilRegistry(args[0]);
        Citizen maria = new Citizen("Maria", "Ad", "Petrova",
                Sex.FEMALE, FamilyType.NOT_MARRIED, null);
        Citizen stepan = new Citizen("Stepan", "Ad", "Prokhorov",
                Sex.MALE, FamilyType.NOT_MARRIED, null);
        Citizen jane = new Citizen("Jane", "Ad", "Doe",
                Sex.FEMALE, FamilyType.NOT_MARRIED, null);
        Citizen jack = new Citizen("Jack", "Ad", "Dex",
                Sex.MALE, FamilyType.MARRIED, jane);
        jane.setMarriedWith(jack);
        Citizen irina = new Citizen("Irina", "Ad", "Testova",
                Sex.FEMALE, FamilyType.MARRIED, null);
        Citizen mike = new Citizen("Mike", "Ad", "Ivanov",
                Sex.MALE, FamilyType.NOT_MARRIED, irina);
        mike.setMarriedWith(irina);
        Citizen elena = new Citizen("elena", "Ad", "Bolshova",
                Sex.FEMALE, FamilyType.NOT_MARRIED, null);
        Citizen nikita = new Citizen("Nikita", "Ad", "Nikitin",
                Sex.MALE, FamilyType.NOT_MARRIED, null);
        Citizen son1 = new Citizen("Bill", "Ad", "Billy",
                Sex.MALE, FamilyType.NOT_MARRIED, null);
        Citizen son2 = new Citizen("Bob", "Ad", "Bills",
                Sex.MALE, FamilyType.NOT_MARRIED, null);
        Citizen son3 = new Citizen("Lilly", "Ad", "Billian",
                Sex.FEMALE, FamilyType.NOT_MARRIED, null);
        civilRegistry.weddingRegistration(maria, stepan, LocalDate.of(2024, 3, 4));
        civilRegistry.weddingRegistration(jane, jack, LocalDate.of(2024, 3, 4));
        civilRegistry.divorceRegistration(irina, mike, LocalDate.of(2024, 3, 4));
        civilRegistry.childBirth(son1, elena, nikita, LocalDate.of(2024, 3, 4));
        civilRegistry.childBirth(son2, irina, mike, LocalDate.of(2024, 3, 4));
        civilRegistry.childBirth(son3, jane, jack, LocalDate.of(2024, 3, 4));
        System.out.println(civilRegistry.makeStatistics(LocalDate.of(2024, 3, 4)));
    }
}
