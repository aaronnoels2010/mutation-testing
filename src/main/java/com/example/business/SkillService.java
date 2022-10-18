package com.example.business;

import com.example.dto.AutoMapper;
import com.example.dto.skill.CreateSkillDto;
import com.example.dto.skill.SkillDto;
import com.example.model.Skill;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class SkillService {
    public List<SkillDto> getAll() {
        return Skill.streamAll().map(skill -> AutoMapper.INSTANCE.skillToDto((Skill) skill)).toList();
    }

    public SkillDto createSkill(CreateSkillDto createSkill) {
        var newSkill = Skill.builder().name(createSkill.getName()).build();
        newSkill.persist();
        return AutoMapper.INSTANCE.skillToDto(newSkill);
    }
}
