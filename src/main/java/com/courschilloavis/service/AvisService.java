package com.courschilloavis.service;

import com.courschilloavis.models.Avis;
import com.courschilloavis.repository.AvisRepository;
import org.springframework.stereotype.Service;

@Service
public class AvisService {


    private final AvisRepository avisRepository;

    public AvisService(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    public void create(Avis avis){

        this.avisRepository.save(avis);

    }
}
