package com.example.dto.person;

import com.example.dto.skill.SkillDto;
import lombok.Data;

import java.util.List;

@Data
public class PersonDto {
    private String name;
    private List<SkillDto> skills;
}
