package com.example.dto.person;

import com.example.dto.skill.SkillDto;
import com.example.model.Seniority;
import lombok.Data;

import java.util.List;

@Data
public class PersonDto {
    private String name;
    private Seniority seniority;
    private Integer yearsOfExperience;
    private boolean canBeEM;
    private boolean canBeLTC;
    private List<SkillDto> skills;
}
