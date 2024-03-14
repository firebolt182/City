package org.javaacademy;

import java.time.LocalDate;

public class RunnerTest {
    public static void main(String[] args) {
        CivilRegistry civilRegistry = new CivilRegistry("TEST_ZAGS");
        Citizen maria = new Citizen("Maria", "Ad", "Petrova",
                false, FamilyType.NOT_MARRIED);
        Citizen stepan = new Citizen("Stepan", "Ad", "Prokhorov",
                true, FamilyType.NOT_MARRIED);
        Citizen jane = new Citizen("Jane", "Ad", "Doe",
                false, FamilyType.NOT_MARRIED);
        Citizen jack = new Citizen("Jack", "Ad", "Dex",
                true, FamilyType.MARRIED);
        jack.setMarriedWith(jane);
        jane.setMarriedWith(jack);
        Citizen irina = new Citizen("Irina", "Ad", "Testova",
                false, FamilyType.MARRIED);
        Citizen mike = new Citizen("Mike", "Ad", "Ivanov",
                true, FamilyType.NOT_MARRIED);
        irina.setMarriedWith(mike);
        mike.setMarriedWith(irina);
        Citizen elena = new Citizen("elena", "Ad", "Bolshova",
                false, FamilyType.NOT_MARRIED);
        Citizen nikita = new Citizen("Nikita", "Ad", "Nikitin",
                true, FamilyType.NOT_MARRIED);
        Citizen son1 = new Citizen("Bill", "Ad", "Billy",
                true, FamilyType.NOT_MARRIED);
        Citizen son2 = new Citizen("Bob", "Ad", "Bills",
                true, FamilyType.NOT_MARRIED);
        Citizen son3 = new Citizen("Lilly", "Ad", "Billian",
                false, FamilyType.NOT_MARRIED);
        civilRegistry.weddingRegistration(maria, stepan, LocalDate.of(2024, 3, 4));
        civilRegistry.weddingRegistration(jane, jack, LocalDate.of(2024, 3, 4));
        civilRegistry.divorceRegistration(irina, mike, LocalDate.of(2024, 3, 4));
        civilRegistry.childBirth(son1, elena, nikita, LocalDate.of(2024, 3, 4));
        civilRegistry.childBirth(son2, irina, mike, LocalDate.of(2024, 3, 4));
        civilRegistry.childBirth(son3, jane, jack, LocalDate.of(2024, 3, 4));
        System.out.println(civilRegistry.makeStatistics(LocalDate.of(2024, 3, 4)));
    }
}
