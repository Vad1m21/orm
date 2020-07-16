package com.povar.orm.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.namespace.QName;
import java.math.BigDecimal;

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
}
