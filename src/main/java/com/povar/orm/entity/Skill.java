package com.povar.orm.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
}
