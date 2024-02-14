package com.esisba.first.API;

import com.esisba.first.entities.Account;
import com.esisba.first.entities.Client;
import com.esisba.first.repository.AccountRepository;
import com.esisba.first.repository.ClientRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("client-api")
public class APIController {
    @Resource
    ClientRepository clientRepository;
    @Resource
    AccountRepository accountRepository;


    @GetMapping("/client/all")
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable("id") Long idclient) {
        return clientRepository.findById(idclient).get();
    }

    @GetMapping("/client")
    public Client getClientById2(@RequestParam("id") Long idclient) {
        return clientRepository.findById(idclient).get();
    }

//    @GetMapping("/client")
//    public List<Client> getClientByName(@RequestParam("name") String name) {
//        return clientRepository.findClientByName(name);
//    }

    @PostMapping("/client")
    public Client createNewClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PostMapping("/account")
    public Account createNewAccount(@RequestBody AccountDTO accountDTO) {


        Account account = new Account();
        account.setLogin(accountDTO.getLogin());
        account.setPassword(accountDTO.getPassword());
        account.setDateCreation(new Date());
        Client client = clientRepository.findById(accountDTO.getIdClient()).get();
        account.setClient(client);
        return accountRepository.save(account);
    }


}

