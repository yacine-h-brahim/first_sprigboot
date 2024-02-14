package com.esisba.first;

import com.esisba.first.entities.Account;
import com.esisba.first.entities.Client;
import com.esisba.first.entities.Gender;
import com.esisba.first.repository.AccountRepository;
import com.esisba.first.repository.ClientRepository;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class FirstApplication implements CommandLineRunner {
    @Resource
    ClientRepository clientRepository;
    @Resource
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Client client1 = new Client(null, "yacine", "y.hadjbrahim@esi-sba.dz", Gender.Homme, null);

        clientRepository.save(client1);
        clientRepository.findAll().forEach(System.out::println);

        Client client = clientRepository.findById(1L).get();
        System.out.println("{{{{{{{{{{client.getIdClient()}}}}}}}}}}}");

        Account account = new Account(null, "login", "password", new Date(), client);
        accountRepository.save(account);


        clientRepository.findClientByName("yacine").forEach(System.out::println);

    }
}
