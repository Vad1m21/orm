package com.povar.orm;

import com.povar.orm.entity.Company;
import com.povar.orm.entity.Project;
import com.povar.orm.service.ServiceFactory;

import java.lang.ref.PhantomReference;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Main {

    private static final ServiceFactory serviceFactory = new ServiceFactory();

    public static void main(String[] args) {
        //System.out.println(serviceFactory.getDeveloperService().getDevelopersFromProject(2l));
        //System.out.println(serviceFactory.getProjectService().getProjectFromDB());
        //System.out.println(serviceFactory.getDeveloperService().getDevelopersBySkill("java"));
       // System.out.println(serviceFactory.getDeveloperService().getDevelopersByLevel("junior"));
    }

}


/*

1. //"select p.date, p.name, count(pd.developer_id) from projects p join developers_projects pd on p.project_id = pd.project_id group by pd.project_id";


3. -----"select * from developers_projects pd inner join projects p on pd.project_id = p.project_id inner join developers d on pd.developer_id = d.developers_id where p.project_id = %d"

4. -----" SELECT * FROM my_db.developers_skills ds inner join developers d on ds.developer_id = d.developers_id inner join skills s on ds.skill_id = s.Skills_id where s.name = '%s' "

5.--- "SELECT * FROM my_db.developers_skills ds inner join developers d on ds.developer_id = d.developers_id inner join skills s on ds.skill_id = s.Skills_id  where s.level = '%s' group by d.developers_id"
 */




