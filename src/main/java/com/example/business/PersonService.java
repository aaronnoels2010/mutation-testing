package com.example.business;

import com.example.dto.AutoMapper;
import com.example.dto.person.CreatePersonDto;
import com.example.dto.person.PersonDto;
import com.example.model.Person;
import com.example.model.Skill;

import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequestScoped
public class PersonService {
    public List<PersonDto> getAllPersons() {
        return Person.streamAll().toList().stream().map(person -> AutoMapper.INSTANCE.personToDto((Person) person)).collect(Collectors.toList());
    }

    public PersonDto addPerson(CreatePersonDto newPersonDto) {
        var newPerson = AutoMapper.INSTANCE.createToPerson(newPersonDto);
        newPerson.persist();
        if (Objects.equals(newPerson.getName(), "error")) {
            throw new RuntimeException("Something went wrong");
        }
        return AutoMapper.INSTANCE.personToDto(newPerson);
    }

    public PersonDto addSkill(Long id, String skill) {
        var person = (Person) Person.findByIdOptional(id).orElseThrow();
        var foundedSkill = (Skill) Skill.find("name", skill).firstResultOptional().orElseThrow();
        person.addSkill(foundedSkill);
        return AutoMapper.INSTANCE.personToDto(person);
    }
}
