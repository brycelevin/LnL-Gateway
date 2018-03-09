package com.nexient.lnl.gateway.clients;

import com.nexient.lnl.gateway.dto.ClientDTO;
import com.nexient.lnl.gateway.fallback.ClientsClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "clients-service", fallbackFactory = ClientsClientFallbackFactory.class)
public interface ClientsClient {

    @RequestMapping(value = "/Client", method = RequestMethod.GET)
    List<ClientDTO> getClients();

    @RequestMapping(value = "/Client", method = RequestMethod.POST)
    ClientDTO createClient(@RequestBody ClientDTO clientDto);

}
