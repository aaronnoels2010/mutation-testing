package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill extends PanacheEntityBase {

  @Id
  @GeneratedValue
  public Long id;

  @Column(unique = true)
  public String name;

  public Category category;

  @ManyToMany(mappedBy = "skills")
  private List<Person> persons;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Skill skill = (Skill) o;
    return name.equals(skill.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
