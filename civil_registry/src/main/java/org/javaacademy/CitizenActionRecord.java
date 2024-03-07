package org.javaacademy;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@ToString
public class CitizenActionRecord {
    LocalDate date;
    CitizenAction action;
    List<Citizen> citizens;
}
