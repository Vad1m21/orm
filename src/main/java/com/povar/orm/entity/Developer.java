package com.povar.orm.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode
@ToString
@Data
@Entity
@Table(name = "developers")
public class Developer {



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "developers_id")
    private Long developerId;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToMany(mappedBy = "developers",cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "developers_skills",
            joinColumns = {@JoinColumn(name = "developer_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private Set<Skill> skills = new HashSet<>();
}
