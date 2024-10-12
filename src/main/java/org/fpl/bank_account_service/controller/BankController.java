package org.fpl.bank_account_service.controller;

import jakarta.websocket.server.PathParam;
import org.fpl.bank_account_service.entities.Bankaccount;
import org.fpl.bank_account_service.repository.Bankrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class BankController {

    @Autowired
    private Bankrepository bankrepository;
    @GetMapping("/banks")
    public List<Bankaccount> bancks(){
        return bankrepository.findAll();
    }
    @GetMapping("/banks/{id}")
    public Bankaccount findbyid(@PathVariable String id){
        return bankrepository.findById(id).orElseThrow(()->new RuntimeException(String.format("ACCOUNT %s not found 😒",id)));
    }
    @PostMapping("/banks")
    public Bankaccount savebank(@RequestBody Bankaccount bankaccount){
        bankaccount.setId(UUID.randomUUID().toString());
        bankaccount.setCreateAt(new Date());
        return bankrepository.save(bankaccount);
    }
    @PostMapping("/banks/{id}")
    public Bankaccount updatebanck(@PathVariable String id,@RequestBody Bankaccount bankaccount){
        Bankaccount bankaccount1=bankrepository.findById(id).orElseThrow();
        bankaccount1.setType(bankaccount.getType());
        bankaccount1.setBalance(bankaccount.getBalance());
        bankaccount1.setCurrency(bankaccount.getCurrency());
        bankaccount1.setCreateAt(bankaccount.getCreateAt());
        return bankrepository.save(bankaccount1);
    }

    @DeleteMapping("/banks/{id}")
    public void deletebanck(@RequestBody Bankaccount bankaccount){
         bankrepository.delete(bankaccount);
    }
}
