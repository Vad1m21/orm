package com.povar.orm.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Data
@Entity
@Table(name = "companies")
public class Company {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "name")
    private String name;

    @Column(name = "specification")
    private String specification;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "companies_projects",
            joinColumns = {@JoinColumn(name = "company_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")}
    )
    private Set<Project> projects = new HashSet<Project>();




}