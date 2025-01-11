package com.courschilloavis.service;

import com.courschilloavis.dto.ClientDTO;
import com.courschilloavis.mapper.ClientDTOMapper;
import com.courschilloavis.models.Client;
import com.courschilloavis.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;


@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientDTOMapper clientDTOMapper;

    public ClientService(ClientRepository clientRepository, ClientDTOMapper clientDTOMapper) {
        this.clientRepository = clientRepository;
        this.clientDTOMapper = clientDTOMapper;
    }


    public void create(Client client){
        Client clientInBdd= this.clientRepository.findByEmail(client.getEmail());
        if(clientInBdd == null) {
            this.clientRepository.save(client);
        }
    }

    public Stream<ClientDTO> search(){
        return this.clientRepository.findAll()
                .stream().map(clientDTOMapper);
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
