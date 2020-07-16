package com.povar.orm;

import com.povar.orm.service.ServiceFactory;


public class Main {

    private static final ServiceFactory serviceFactory = new ServiceFactory();

    public static void main(String[] args) {

       // serviceFactory.getCompanyService().createCompany();
        serviceFactory.getCompanyService().findAll();
    }
}
