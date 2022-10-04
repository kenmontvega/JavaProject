package com.nlxa.java.usecase.client;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.client.ClientListResponse;
import com.nlxa.java.client.ClientBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class GetAllClients {

    private ClientBusiness clientBusiness;

    @Autowired
    public GetAllClients(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    @Async
    public Future<ClientListResponse> execute(){
        log.info("Call to: GetAllClients.execute()");
        AsyncResponse<ClientListResponse> response = null;
        try {
            response = new AsyncResponse<>(this.clientBusiness.getAllClients());
        } catch (Exception e){
            log.error("Error in: GetAllClients.execute()", e);
        }
        return response;
    }
}
