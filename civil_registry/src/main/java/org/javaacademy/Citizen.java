package org.javaacademy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Citizen extends Human{
    FamilyType familyType;
    Human marriedWith;

    public Citizen(String name, String middleName, String lastName, Sex sex,
                   FamilyType familyType, Human marriedWith) {
        super(name, middleName, lastName, sex);
        this.familyType = familyType;
        if (familyType == FamilyType.MARRIED) {
            this.marriedWith = marriedWith;
        } else {
            this.marriedWith = null;
        }
    }
}
