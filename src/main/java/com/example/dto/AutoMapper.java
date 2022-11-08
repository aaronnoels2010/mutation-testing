package com.example.dto;

import com.example.dto.person.CreatePersonDto;
import com.example.dto.person.PersonDto;
import com.example.dto.skill.SkillDto;
import com.example.model.Person;
import com.example.model.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoMapper {
    AutoMapper INSTANCE = Mappers.getMapper( AutoMapper.class );

    @Mapping(target = "skills", source = "skills")
    PersonDto personToDto(Person person);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "seniority", ignore = true)
    @Mapping(target = "canBeEM", ignore = true)
    @Mapping(target = "canBeLTC", ignore = true)
    @Mapping(target = "skills", ignore = true)
    Person createToPerson(CreatePersonDto newPersonDto);

    SkillDto skillToDto(Skill skill);
}
