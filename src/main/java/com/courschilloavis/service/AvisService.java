package com.courschilloavis.service;

import com.courschilloavis.models.Avis;
import com.courschilloavis.models.Client;
import com.courschilloavis.repository.AvisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisService {

    private final ClientService clientService;
    private final AvisRepository avisRepository;

    public AvisService(AvisRepository avisRepository, ClientService clientService) {
        this.avisRepository = avisRepository;
        this.clientService = clientService;
    }

    public void create(Avis avis){
        Client client = this.clientService.readOrCreate(avis.getClient());
        avis.setClient(client);
        this.avisRepository.save(avis);

    }

    public List<Avis> search() {
        return this.avisRepository.findAll();
    }
}
