package org.fpl.bank_account_service.controller;

import org.fpl.bank_account_service.entities.Bankaccount;
import org.fpl.bank_account_service.repository.Bankrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountController {
    @Autowired
    private Bankrepository bankrepository;
    @QueryMapping
    public List<Bankaccount> accountsList(){
        return bankrepository.findAll();
    }

    @QueryMapping
    public Bankaccount accountById(@Argument String id){
        return bankrepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
}
