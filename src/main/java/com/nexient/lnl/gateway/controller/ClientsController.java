package com.nexient.lnl.gateway.controller;

import com.nexient.lnl.gateway.clients.ClientsClient;
import com.nexient.lnl.gateway.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ClientsController {

    @Autowired
    ClientsClient clientsClient;

    @RequestMapping(value = "/client", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDTO> getClients() {
        List<ClientDTO> clients = clientsClient.getClients();

        for(ClientDTO client : clients) {
            client.setGlCode(UUID.randomUUID().toString());
        }

        return clients;
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO createClient(@Valid @RequestBody ClientDTO clientDto) {
        return clientsClient.createClient(clientDto);
    }
}
