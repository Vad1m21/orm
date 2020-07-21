package com.povar.orm.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode
@ToString
@Data
@Entity
@Table(name = "skills")
public class Skill {



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "skills_id")
    private Long skillId;

    @Column(name = "name")
    private String name;

    @Column (name = "level")
    private Level level;

    @ManyToMany(mappedBy = "skills",cascade = CascadeType.ALL)
    private Set<Developer> developers = new HashSet<>();

 }
