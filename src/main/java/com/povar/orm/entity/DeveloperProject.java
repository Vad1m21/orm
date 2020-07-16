package com.povar.orm.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "developers_projects")
public class DeveloperProject {



    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "developer_id")
    private Long developerId;

    @Column(name = "project_id")
    private Long projectId;
}
