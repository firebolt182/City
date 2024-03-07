package org.javaacademy;

import lombok.AccessLevel;
import lombok.*;
import lombok.experimental.*;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Human {
    @NonNull
    String name;
    @NonNull
    String middleName;
    @NonNull
    String lastName;
    @NonNull
    Sex sex;
    Human father;
    Human mother;
    List<Human> children;

    public Human(String name, String middleName, String lastName, Sex sex) {
        this.name = capitalize(name);
        this.middleName = capitalize(middleName);
        this.lastName = capitalize(lastName);
        this.sex = sex;
    }

    private String capitalize(String value) {
        return StringUtils.capitalize(StringUtils.lowerCase(value));
    }

    public void indicateParents(Human mother, Human father) throws SexException {
        if (mother.getSex().equals(father.getSex())) {
            throw new SexException("Пол отца и матери совпадает");
        }
        father.children.add(this);
        mother.children.add(this);
        this.father = father;
        this.mother = mother;
    }

    public Human createChild(String name, String middleName, String lastName,
                             Sex sex, Human father) throws SexException {
        if (this.getSex().equals(father.getSex())) {
            throw new SexException("Пол отца и матери совпадает");
        }
        Human child = new Human(name, middleName, lastName, sex);
        child.indicateParents(this, father);
        return child;
    }

    public String getFullName() {
        return String.format("%s %s %s", lastName, name, middleName);
    }
}
