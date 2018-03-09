package com.nexient.lnl.gateway.fallback;

import com.nexient.lnl.gateway.clients.ClientsClient;
import com.nexient.lnl.gateway.dto.ClientDTO;
import feign.FeignException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ClientsClientFallback implements ClientsClient {

    private final Throwable cause;

    public ClientsClientFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public List<ClientDTO> getClients() {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            // Treat the HTTP 404 status
        }

        List<ClientDTO> failureList = new ArrayList<ClientDTO>();

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientId(1);
        clientDTO.setClientName("Help, I'm trapped in a failure!");
        clientDTO.setGlCode("help!");

        failureList.add(clientDTO);

        return failureList;
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            // Treat the HTTP 404 status
        }

        return clientDTO;
    }

}
