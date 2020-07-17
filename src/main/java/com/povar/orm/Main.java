package com.povar.orm;

import com.povar.orm.entity.Company;
import com.povar.orm.service.ServiceFactory;


public class Main {

    private static final ServiceFactory serviceFactory = new ServiceFactory();

    public static void main(String[] args) {


        //System.out.println(serviceFactory.getCompanyService().findAll());
        Company company = new Company();
        company.setName("Test");
        company.setSpecification("test");
       // serviceFactory.getCompanyService().create(company);
        System.out.println(serviceFactory.getCompanyService().findAll());
        //serviceFactory.getCompanyService().delete(5l);
        //System.out.println(serviceFactory.getCompanyService().findAll());
        System.out.println(serviceFactory.getCompanyService().findById(3l));
    }
}
