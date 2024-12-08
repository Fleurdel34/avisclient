package com.courschilloavis.service;

import com.courschilloavis.enums.TypeAvis;
import com.courschilloavis.models.Avis;
import com.courschilloavis.models.Client;
import com.courschilloavis.repository.AvisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisService {

    private final AvisRepository avisRepository;
    private final ClientService clientService;

    public AvisService(AvisRepository avisRepository, ClientService clientService) {
        this.avisRepository = avisRepository;
        this.clientService = clientService;
    }


    public void create(Avis avis) {
        Client client = this.clientService.readOrCreate(avis.getClient());
        avis.setClient(client);
        if(avis.getText().contains("pas")){
            avis.setType(TypeAvis.NEGATIF);
        }else{
            avis.setType(TypeAvis.POSITIF);
        }
        this.avisRepository.save(avis);
    }

    public List<Avis> search(TypeAvis type) {
        if(type == null){
            return this.avisRepository.findAll();
        }else{
            return this.avisRepository.findByType(type);
        }
    }

    public void delete(Long id) {
        this.avisRepository.deleteById(id);
    }
}
