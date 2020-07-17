package com.povar.orm.service;

import com.povar.orm.entity.Developer;
import com.povar.orm.entity.Skill;
import com.povar.orm.repository.DeveloperDAO;
import com.povar.orm.repository.SkillDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SkillService {

    private final SkillDAO skillDAO;


    public void create(Skill skill){
        skillDAO.save(skill);
    }

    public void update(Skill skill, Long id){
        skillDAO.update(skill,id);
    }

    public List<Skill> findAll(){
        return skillDAO.getAll();
    }

    public void delete(Long id){ skillDAO.remove(id); }

    public Skill findById(Long id){ return skillDAO.getById(id);}

}
