package ru.gil.thymeleaf_demo.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.gil.thymeleaf_demo.model.Gender.FEMALE;
import static ru.gil.thymeleaf_demo.model.Gender.MALE;

@Data
@Builder
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;


    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isMan() {
        return gender== MALE;
    }
    public static Map<String, EmployeeDto> getMap() {
        Map<String, EmployeeDto> employeeDtoMap = new HashMap<>();
        employeeDtoMap.put("Peter", getEmployeeFirst());
        return employeeDtoMap;
    }
    public static EmployeeDto getEmployeeFirst() {
        return EmployeeDto.builder()
                .firstName("Peter")
                .lastName("Parker")
                .email("user@mail.ru")
                .gender(MALE)
                .build();
    }

    public static EmployeeDto getEmployeeSecond() {
        return EmployeeDto.builder()
                .firstName("Mark")
                .lastName("Phunt")
                .email("boberr@mail.ru")
                .gender(MALE)
                .build();
    }

    public static EmployeeDto getEmployeeThree() {
        return EmployeeDto.builder()
                .firstName("Elena")
                .lastName("Super")
                .email("elenar@mail.ru")
                .gender(FEMALE)
                .build();
    }

    public static List<EmployeeDto> getEmployeeList() {
        return List.of(
                getEmployeeFirst(),
                getEmployeeSecond(),
                getEmployeeThree()
        );
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + gender;
    }
}
