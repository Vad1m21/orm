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
@Table(name = "customers")
public class Customer {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

   @ManyToMany(mappedBy = "customers",cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();


}
