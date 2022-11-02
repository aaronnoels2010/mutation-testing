package com.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Test
    public void shouldGetName() {
        var expectedName = "Jef";
        var person = Person.builder().name(expectedName).build();

        assertEquals(expectedName, person.getName());
    }

    @Test
    public void shouldReturnJunior() {
        var expectedName = "Jef";
        var expectedYears = 0;
        var expectedSeniority = Seniority.JUNIOR;
        var expectedEm = false;
        var expectedLtc = false;

        var person = new Person(expectedName, expectedYears);
        assertEquals(expectedName, person.getName());
        assertEquals(expectedYears, person.getYearsOfExperience());
        assertEquals(expectedSeniority, person.getSeniority());
        assertEquals(expectedEm, person.isCanBeEM());
        assertEquals(expectedLtc, person.isCanBeLTC());
    }

    @Test
    public void shouldReturnMedior() {
        var expectedName = "Jef";
        var expectedYears = 2;
        var expectedSeniority = Seniority.MEDIOR;
        var expectedEm = true;
        var expectedLtc = false;

        var person = new Person(expectedName, expectedYears);
        assertEquals(expectedName, person.getName());
        assertEquals(expectedYears, person.getYearsOfExperience());
        assertEquals(expectedSeniority, person.getSeniority());
        assertEquals(expectedEm, person.isCanBeEM());
        assertEquals(expectedLtc, person.isCanBeLTC());
    }

    @Test
    public void shouldReturnSenior() {
        var expectedName = "Jef";
        var expectedYears = 3;
        var expectedSeniority = Seniority.SENIOR;
        var expectedEm = true;
        var expectedLtc = true;

        var person = new Person(expectedName, expectedYears);
        assertEquals(expectedName, person.getName());
        assertEquals(expectedYears, person.getYearsOfExperience());
        assertEquals(expectedSeniority, person.getSeniority());
        assertEquals(expectedEm, person.isCanBeEM());
        assertEquals(expectedLtc, person.isCanBeLTC());
    }

    @Test
    public void shouldReturnPrinciple() {
        var expectedName = "Jef";
        var expectedYears = 5;
        var expectedSeniority = Seniority.PRINCIPAL;
        var expectedEm = true;
        var expectedLtc = false;

        var person = new Person(expectedName, expectedYears);
        assertEquals(expectedName, person.getName());
        assertEquals(expectedYears, person.getYearsOfExperience());
        assertEquals(expectedSeniority, person.getSeniority());
        assertEquals(expectedEm, person.isCanBeEM());
        assertEquals(expectedLtc, person.isCanBeLTC());
    }

    @Test
    public void shouldThrowIllegalArgument() {
        var expectedName = "Jef";
        var expectedYears = -1;

        assertThrows(IllegalArgumentException.class, () -> new Person(expectedName, expectedYears));
    }

    @Test
    public void shouldGetAllTheSkills() {
        List<Skill> expectedSkills = new ArrayList<Skill>();
        expectedSkills.add(Skill.builder().name("C#").build());
        expectedSkills.add(Skill.builder().name("java").build());
        expectedSkills.add(Skill.builder().name("python").build());

        var person = Person.builder().skills(expectedSkills).build();

        Assertions.assertIterableEquals(expectedSkills, person.getSkills());
    }

    @Test
    public void shouldAddSkillIfItIsUnique() {
        List<Skill> expectedSkills = new ArrayList<Skill>();
        expectedSkills.add(Skill.builder().name("C#").build());
        expectedSkills.add(Skill.builder().name("java").build());
        expectedSkills.add(Skill.builder().name("python").build());
        var person = Person.builder().skills(expectedSkills).build();

        person.addSkill(Skill.builder().name("rust").build());

        Assertions.assertEquals(4, person.getSkills().size());
    }

    @Test
    public void shouldNotAddSkillIfItIsNotUnique() {
        List<Skill> expectedSkills = new ArrayList<Skill>();
        expectedSkills.add(Skill.builder().name("C#").build());
        expectedSkills.add(Skill.builder().name("java").build());
        expectedSkills.add(Skill.builder().name("python").build());
        var person = Person.builder().skills(expectedSkills).build();

        person.addSkill(Skill.builder().name("java").build());

        Assertions.assertEquals(3, person.getSkills().size());
    }
}
