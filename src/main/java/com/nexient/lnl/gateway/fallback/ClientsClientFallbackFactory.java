package com.nexient.lnl.gateway.fallback;

import com.nexient.lnl.gateway.clients.ClientsClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ClientsClientFallbackFactory implements FallbackFactory<ClientsClient> {

    @Override
    public ClientsClient create(Throwable throwable) {
        return new ClientsClientFallback(throwable);
    }

}