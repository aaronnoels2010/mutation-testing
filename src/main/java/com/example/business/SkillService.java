package com.example.business;

import com.example.dto.AutoMapper;
import com.example.dto.skill.CreateSkillDto;
import com.example.dto.skill.SkillDto;
import com.example.model.Category;
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
        if (createSkill.getName().length() < 10) {
            throw new IllegalArgumentException("Skill naam moet minimaal 10 karakters lang zijn.");
        } else {
            var newSkill = Skill.builder().name(createSkill.getName()).category(Category.valueOfIgnoreCase(createSkill.getCategory())).build();
            newSkill.persist();
            return AutoMapper.INSTANCE.skillToDto(newSkill);
        }
    }
}
