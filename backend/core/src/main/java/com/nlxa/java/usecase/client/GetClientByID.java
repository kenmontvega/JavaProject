package com.nlxa.java.usecase.client;

import com.nlxa.java.dto.client.GetClientByIdRequest;
import com.nlxa.java.dto.client.GetClientByIdRequest;
import com.nlxa.java.dto.client.ClientResponse;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.client.ClientBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetClientByID {

    private ClientBusiness clientBusiness;

    @Autowired
    public GetClientByID(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    public ClientResponse execute(GetClientByIdRequest request){
        log.info("Call to: GetClientByID.execute()");
        ClientResponse response = null;
        String verifyInfo = verifyRequestInfo(request);
        if (verifyInfo.equals("")) {
            response = this.clientBusiness.getByID(request);
        } else {
            log.error("Error in: GetClientByID.execute() -> Verify if th information is complete");
            throw new RequestException(verifyInfo, "Error in: GetClientByID.execute() -> Verify if th information is complete");
        }
        return response;
    }


    private String verifyRequestInfo(GetClientByIdRequest request){
        log.info("Call to: ClientBusiness.verifyRequestInfo()");
        String result = "";
        if (request == null || request.getClient_id() == null){
            log.warn("Warn: The request or the request info is null");
            result = "Warn: The request or the request info is null";
        } else if (request.getClient_id().equals("")) {
            log.warn("Warn: The request info is empty");
            result = "Warn: The request info is empty";
        }
        return result;
    }
}
