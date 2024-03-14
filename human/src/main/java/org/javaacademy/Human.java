package org.javaacademy;

import lombok.AccessLevel;
import lombok.*;
import lombok.experimental.*;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

@Getter
public class Human {
    @NonNull
    private String name;
    @NonNull
    private String middleName;
    @NonNull
    private String lastName;
    @NonNull
    private boolean isMale;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, String middleName, String lastName, boolean isMale) {
        this.name = capitalize(name);
        this.middleName = capitalize(middleName);
        this.lastName = capitalize(lastName);
        this.isMale = isMale;
    }

    private String capitalize(String value) {
        String result = toLowerCase(value);
        return StringUtils.capitalize(result);
    }

    private String toLowerCase(String value) {
        return StringUtils.lowerCase(value);
    }

    public void indicateParents(Human mother, Human father) {
        if (mother.isMale == father.isMale) {
            throw new RuntimeException("Пол отца и матери совпадает");
        }
        father.children.add(this);
        mother.children.add(this);
        this.father = father;
        this.mother = mother;
    }

    public Human createChild(String name, String middleName, String lastName,
                             boolean isMale, Human father) {
        if (this.isMale == father.isMale) {
            throw new RuntimeException("Пол отца и матери совпадает");
        }
        Human child = new Human(name, middleName, lastName, isMale);
        child.indicateParents(this, father);
        return child;
    }

    public String getFullName() {
        return String.format("%s %s %s", lastName, name, middleName);
    }
}
