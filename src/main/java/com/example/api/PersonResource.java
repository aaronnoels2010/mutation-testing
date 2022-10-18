package com.example.api;

import com.example.business.PersonService;
import com.example.dto.person.AddSkillToPersonDto;
import com.example.dto.person.CreatePersonDto;
import com.example.dto.person.PersonDto;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestPath;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("persons")
public class PersonResource {
    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDto> getAll() {
        return this.personService.getAllPersons();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(201)
    @Transactional
    public PersonDto create(CreatePersonDto createPersonDto) {
        return personService.addPerson(createPersonDto);
    }

    @POST
    @Path("{id}/skills")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(201)
    @Transactional
    public PersonDto addSkills(@RestPath Long id, AddSkillToPersonDto skill) {
        return personService.addSkill(id, skill.getName());
    }
}
