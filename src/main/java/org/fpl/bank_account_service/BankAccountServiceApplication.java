package org.fpl.bank_account_service;

import graphql.schema.GraphQLScalarType;
import org.fpl.bank_account_service.entities.AccountType;
import org.fpl.bank_account_service.entities.Bankaccount;
import org.fpl.bank_account_service.repository.Bankrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.rmi.server.UID;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(Bankrepository bankrepository) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				Bankaccount bankaccount = Bankaccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
						.balance(10000 + Math.random() * 90000)
						.currency("MAD ")
						.createAt(new Date())
						.build();
				bankrepository.save(bankaccount);
			}
		};
	}

}
