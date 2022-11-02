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
    private Seniority seniority;

    @Getter
    private Integer yearsOfExperience;

    @Getter
    private boolean canBeEM;

    @Getter
    private boolean canBeLTC;

    @Getter
    @Setter
    @ManyToMany
    private List<Skill> skills;

    public void setYearsOfExperience(Integer yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Jaren ervaring mag niet minder dan nul zijn!");
        }
        this.yearsOfExperience = yearsOfExperience;

        setSeniority(yearsOfExperience);

        setCanBeEM(this.seniority);

        setCanBeLTC(this.seniority);
    }

    private void setSeniority(Integer yearsOfExperience){
        if (yearsOfExperience < 1) {
            this.seniority = Seniority.JUNIOR;
        } else if (yearsOfExperience < 3) {
            this.seniority = Seniority.MEDIOR;
        } else if (yearsOfExperience < 5) {
            this.seniority = Seniority.SENIOR;
        } else {
            this.seniority = Seniority.PRINCIPAL;
        }
    }

    private void setCanBeEM(Seniority seniority) {
        if (seniority == Seniority.MEDIOR || seniority == Seniority.SENIOR || seniority == Seniority.PRINCIPAL){
            this.canBeEM = true;
        } else {
            this.canBeEM = false;
        }
    }

    private void setCanBeLTC(Seniority seniority) {
        if (seniority == Seniority.SENIOR)  {
            this.canBeLTC = true;
        } else {
            this.canBeLTC = false;
        }
    }

    public void addSkill(Skill skill) {
        var alreadyExist = skills.contains(skill);
        if (alreadyExist) {
            return;
        }

        skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        var exists = skills.contains(skill);
        if (!exists) {
            return;
        }

        skills.remove(skill);
    }
}