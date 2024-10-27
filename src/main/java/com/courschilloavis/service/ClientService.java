package com.courschilloavis.service;

import com.courschilloavis.models.Client;
import com.courschilloavis.repository.ClientRepository;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void create(Client client){
        this.clientRepository.save(client);
    }
}
