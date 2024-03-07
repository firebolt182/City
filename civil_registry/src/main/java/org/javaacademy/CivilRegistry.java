package org.javaacademy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CivilRegistry {
    @NonNull
    @Getter
    String name;
    List<CitizenActionRecord> citizenRecordings = new ArrayList<>();

    public void childBirth(Citizen child, Citizen mother, Citizen father, LocalDate localDate) {
        citizenRecordings.add(new CitizenActionRecord(localDate, CitizenAction.BIRTH_REGISTRY,
                List.of(child, mother, father)));
    }

    public void weddingRegistration(Citizen woman, Citizen man, LocalDate localDate) {
        checkSex(woman, man);
        changeFamilyType(woman, man, FamilyType.MARRIED);
        changeMarriedWith(woman, man);
        citizenRecordings.add(new CitizenActionRecord(localDate, CitizenAction.WEDDING_REGISTRY,
                List.of(woman, man)));
    }

    public void divorceRegistration(Citizen woman, Citizen man, LocalDate localDate) {
        checkSex(woman, man);
        changeFamilyType(woman, man, FamilyType.DIVORCED);
        woman.setMarriedWith(null);
        man.setMarriedWith(null);
        citizenRecordings.add(new CitizenActionRecord(localDate, CitizenAction.DIVORCE_REGISTRY,
                List.of(woman, man)));
    }

    private void changeFamilyType(Citizen woman, Citizen man, FamilyType familyType) {
        woman.setFamilyType(familyType);
        man.setFamilyType(familyType);
    }

    private void changeMarriedWith(Citizen woman, Citizen man) {
        woman.setMarriedWith(man);
        man.setMarriedWith(woman);
    }

    private void checkSex(Citizen firstPerson, Citizen secondPerson){
        if (firstPerson.getSex() == secondPerson.getSex()) {
            throw new RuntimeException("Ошибка. Пол у двух персон совпадает");
        }
    }

    public String makeStatistics(LocalDate date){
        citizenRecordings.sort(new CivilRegistryComparator());
        List<CitizenActionRecord> actionsByDate = citizenRecordings.stream()
                .filter(record -> record.getDate().equals(date))
                .toList();
        long weddingCount = actionCount(actionsByDate, CitizenAction.WEDDING_REGISTRY);
        long bornCount = actionCount(actionsByDate, CitizenAction.BIRTH_REGISTRY);
        long divorceCount = actionCount(actionsByDate, CitizenAction.DIVORCE_REGISTRY);
        return String.format("Статистика по ЗАГС: %s\n Дата %s/%s/%s"
                        + " количество свадеб - %d, количество разводов - %d, количество рождений - %d",
                this.getName(), date.getDayOfMonth(), date.getMonthValue(), date.getYear(),
                weddingCount, divorceCount, bornCount);
    }

    private long actionCount(List<CitizenActionRecord> actions, CitizenAction citizenAction) {
        return actions.stream()
                .filter(action -> action.getAction().equals(citizenAction))
                .count();
    }
}

