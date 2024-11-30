package com.courschilloavis.service;

import com.courschilloavis.models.Client;
import com.courschilloavis.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void create(Client client){
        Client clientInBdd= this.clientRepository.findByEmail(client.getEmail());
        if(clientInBdd == null) {
            this.clientRepository.save(client);
        }
    }

    public List<Client> search(){
        return this.clientRepository.findAll();
    }

    public Client read(long id) {
        Optional<Client>  optionalClient= this.clientRepository.findById(id);

        return optionalClient.orElse(null);
    }

    public Client readOrCreate(Client clientToCreate){
        Client clientInBdd= this.clientRepository.findByEmail(clientToCreate.getEmail());
        if(clientInBdd == null) {
            clientInBdd= this.clientRepository.save(clientToCreate);
        }
        return clientInBdd;
    }
}
