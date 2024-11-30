package com.courschilloavis.controller;

import com.courschilloavis.models.Avis;
import com.courschilloavis.service.AvisService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "avis", produces= APPLICATION_JSON_VALUE)
public class AvisController {

    private final AvisService avisService;

    public AvisController(AvisService avisService) {
        this.avisService = avisService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Avis avis){
        this.avisService.create(avis);
    }

    @GetMapping
    public @ResponseBody List<Avis> search(){

        return this.avisService.search();

    }

}
