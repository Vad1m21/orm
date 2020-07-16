package com.povar.orm.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "developers_skills")
public class DeveloperSkill {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "developer_id")
    private Long developerId;

    @Column(name = "skill_id")
    private Long skillId;
}
