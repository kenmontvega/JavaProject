package com.nlxa.java.usecase.client;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.client.AddClientRequest;
import com.nlxa.java.dto.client.ClientResponse;
import com.nlxa.java.client.ClientBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AddClient {

    private ClientBusiness clientBusiness;

    @Autowired
    public AddClient(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    @Async
    public Future<ClientResponse> execute(AddClientRequest request){
        log.info("Call to: AddClient.execute()");
        AsyncResponse<ClientResponse> response = null;
        try {
            response = new AsyncResponse<>(this.clientBusiness.addClient(request));
        } catch (Exception e){
            log.error("Error in: AddClient.execute()", e);
        }
        return response;
    }
}
