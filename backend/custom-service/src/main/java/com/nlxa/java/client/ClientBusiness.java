package com.nlxa.java.client;

import com.nlxa.java.domain.Client;
import com.nlxa.java.dto.client.*;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.jpa.ClientJPAComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClientBusiness {

    private ClientJPAComponent clientJPAComponent;

    @Autowired
    public ClientBusiness(ClientJPAComponent clientJPAComponent){
        this.clientJPAComponent = clientJPAComponent;
    }

    public ClientListResponse getAllClients(){
        log.info("Call to: ClientBusiness.getAllClients()");
        ClientListResponse response = null;
        try {
            response = new ClientListResponse();
            List<Client> clients = this.clientJPAComponent.getAll();

            for (Client clientAux : clients){
                response.getClientResponseList().add(new ClientResponse(clientAux));
            }
        } catch (Exception e) {
            log.error("Error in: ClientBusiness.getAllClients() -> Verify that the connection is correct");
        }

        return response;
    }

    public ClientResponse getByID(GetClientByIdRequest request){
        log.info("Call to: ClientBusiness.getByID()");
        ClientResponse response = null;
        try{
            Client client = this.clientJPAComponent.getById(request.getClient_id());
            response = new ClientResponse(client);
        } catch (RequestException e){
            log.error("Error in: ClientBusiness.getByID()", e);
            throw e;
        } catch (Exception e) {
            log.error("Error in: ClientBusiness.getByID() -> Verify that the connection is correct");
            throw new RequestException("Error in: ClientBusiness.getByID()", e.getMessage());
        }
        return response;
    }

    public ClientResponse addClient(AddClientRequest request){
        log.info("Call to: ClientBusiness.addClient()");
        ClientResponse response = null;
        try {
            Client client = this.clientJPAComponent.save(new Client(request));
            response = new ClientResponse(client);
        } catch (Exception e) {
            log.error("Error in: ClientBusiness.addClient() -> Verify that the connection is correct");
        }
        return response;
    }

    public void deleteClient(DeleteClientRequest request){
        log.info("Call to: ClientBusiness.deleteClient()");
        try {
            this.clientJPAComponent.delete(new Client(request));
        } catch (Exception e) {
            log.error("Error in: ClientBusiness.deleteClient() -> Verify that the connection is correct");
        }
    }

    public ClientResponse updateClient(UpdateClientRequest request){
        log.info("Call to: ClientBusiness.updateClient()");
        ClientResponse response = null;
        try {
            Client client = this.clientJPAComponent.update(new Client(request));
            response = new ClientResponse(client);
        } catch (Exception e) {
            log.error("Error in: ClientBusiness.updateClient() -> Verify that the connection is correct");
        }
        return response;
    }
}
