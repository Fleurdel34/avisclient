package com.courschilloavis.service;

import com.courschilloavis.models.Client;
import com.courschilloavis.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
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

        return optionalClient.orElseThrow(
                () -> new EntityNotFoundException("Aucun client n'existe avec cet identifiant")
        );
    }

    public Client readOrCreate(Client clientToCreate){
        Client clientInBdd= this.clientRepository.findByEmail(clientToCreate.getEmail());
        if(clientInBdd == null) {
            clientInBdd= this.clientRepository.save(clientToCreate);
        }
        return clientInBdd;
    }

    public void modify(long id, Client client) {
        Client clientBDD = this.read(id);

        if(clientBDD.getId().equals(client.getId())){
            clientBDD.setEmail(client.getEmail());
            clientBDD.setTelephone(client.getTelephone());
            this.clientRepository.save(clientBDD);
        }


    }
}
