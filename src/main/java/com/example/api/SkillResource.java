package com.example.api;

import com.example.business.SkillService;
import com.example.dto.skill.CreateSkillDto;
import com.example.dto.skill.SkillDto;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("skills")
public class SkillResource {
    private final SkillService skillService;

    public SkillResource(SkillService skillService) {
        this.skillService = skillService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SkillDto> getAll() {
        return this.skillService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(201)
    @Transactional
    public SkillDto create(CreateSkillDto createSkillDto) {
        return skillService.createSkill(createSkillDto);
    }
}
