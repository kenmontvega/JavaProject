package com.nlxa.java.usecase.client;

import com.nlxa.java.dto.client.DeleteClientRequest;
import com.nlxa.java.client.ClientBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteClient {

    private ClientBusiness clientBusiness;

    @Autowired
    public DeleteClient(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    @Async
    public void execute(DeleteClientRequest request){
        log.info("Call to: DeleteClient.execute()");
        try {
            this.clientBusiness.deleteClient(request);
        } catch (Exception e){
            log.error("Error in: GetAllClients.execute()", e);
        }
    }
}
