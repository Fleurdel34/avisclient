package com.courschilloavis.mapper;

import com.courschilloavis.dto.ClientDTO;
import com.courschilloavis.models.Client;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClientDTOMapper implements Function<Client, ClientDTO> {


    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(), client.getEmail(), client.getTelephone());
    }
}
