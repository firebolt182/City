package org.javaacademy;

import org.apache.commons.lang3.StringUtils;
import java.util.List;

public class Human {
    private String name;
    private String middleName;
    private String lastName;
    private Sex sex;
    private Human father = null;
    private Human mother = null;
    private List<Human> children = null;

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human(String name, String middleName, String lastName, Sex sex) {
        this.name = StringUtils.capitalize(name);
        this.middleName = StringUtils.capitalize(middleName);
        this.lastName = StringUtils.capitalize(lastName);
        this.sex = sex;
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
