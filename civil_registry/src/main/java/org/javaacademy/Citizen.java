package org.javaacademy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Citizen extends Human {
    FamilyType familyType;
    Human marriedWith;

    public Citizen(String name, String middleName, String lastName, boolean isMale,
                   FamilyType familyType) {
        super(name, middleName, lastName, isMale);
        this.familyType = familyType;
    }
}
