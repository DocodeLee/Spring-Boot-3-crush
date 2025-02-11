package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository //For component Scanning
public class AccountDAOImpl  implements  AccountDAO{


    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " : Doing My DB Work : ADDING AN ACCOUNT");

    }

    @Override
    public boolean doWork() {

        System.out.println(getClass() + " : running doWork()");
        return true;
    }
}
