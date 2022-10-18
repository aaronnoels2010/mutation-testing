package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToMany
    private List<Skill> skills;

    public void addSkill(Skill skill) {
        var alreadyExist = skills.contains(skill);
        if (alreadyExist) {
            return;
        }

        skills.add(skill);
    }
}