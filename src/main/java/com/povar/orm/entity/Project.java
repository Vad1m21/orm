package com.povar.orm.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Data
@Entity
@Table(name = "projects")
public class Project {



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "projects_id")
    private Long projectId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "cost")
    private BigDecimal cost;

   @ManyToMany(mappedBy = "projects",cascade = CascadeType.ALL)
    private Set<Company> companies = new HashSet<Company>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customers_projects",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")}
    )
    private Set<Customer> customers = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "developers_projects",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "developer_id")}
    )
    private Set<Developer> developers = new HashSet<>();

    private Integer count;
}
