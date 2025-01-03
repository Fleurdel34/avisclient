package com.courschilloavis.controller;

import com.courschilloavis.dto.ErrorEntity;
import com.courschilloavis.models.Client;
import com.courschilloavis.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path="client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @ResponseStatus(value= HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client){
        this.clientService.create(client);
    }

    @GetMapping(produces= APPLICATION_JSON_VALUE)
    public List<Client> search(){
        return this.clientService.search();
    }

    @GetMapping(path="{id}", produces= APPLICATION_JSON_VALUE)
    public Client read(@PathVariable long id){
            return this.clientService.read(id);

    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping(path="{id}", consumes= APPLICATION_JSON_VALUE)
    public void modify(@PathVariable long id, @RequestBody Client client){
        this.clientService.modify(id, client);
    }


}
