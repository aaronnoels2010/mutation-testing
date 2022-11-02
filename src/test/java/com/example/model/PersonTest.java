package com.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void shouldGetName() {
        var expectedName = "Jeff";
        var person = Person.builder().name(expectedName).build();

        assertEquals(expectedName, person.getName());
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
