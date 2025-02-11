package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository //For component Scanning
public class MembershipDAOImpl implements  MembershipDAO{


    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + " : Doing My DB Work : ADDING A Membership  ACCOUNT");
        return true;

    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " running goToSleep()");

    }
}
