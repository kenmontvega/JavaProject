package com.nlxa.java.controller;

import com.nlxa.java.dto.client.*;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.usecase.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    private GetAllClients getAllClients;
    private GetClientByID getClientByID;
    private AddClient addClient;
    private DeleteClient deleteClient;
    private UpdateClient updateClient;

    @Autowired
    public ClientController(GetAllClients getAllClients,
                            GetClientByID getClientByID,
                            AddClient addClient,
                            DeleteClient deleteClient,
                            UpdateClient updateClient){
        this.getAllClients = getAllClients;
        this.getClientByID = getClientByID;
        this.addClient = addClient;
        this.deleteClient = deleteClient;
        this.updateClient = updateClient;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<ClientListResponse> getAllClients() {
        log.info("Call to: ClientController.getAllClients()");
        ClientListResponse response = null;
        try {
            Future<ClientListResponse> result =this.getAllClients.execute();
            response = result.get();
        } catch (Exception e){
            log.error("Error in: ClientController.getAllClients()", e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/byId")
    public ClientResponse getClientByID(@RequestBody GetClientByIdRequest request) {
        log.info("Call to: ClientController.getClientByID()");
        ClientResponse response = null;
        try {
            response = this.getClientByID.execute(request);
        } catch (RequestException  e){
            log.error("Error in: ClientController.getClientByID() ->", e);
            throw e;
        } catch (Exception e){
            log.error("Error in: ClientController.getClientByID() ->", e);
            throw new RequestException(e.getCause().getMessage(), "Error in: ClientController.getClientByID()");
        }
        return response;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ClientResponse> addClient(@RequestBody AddClientRequest request){
        log.info("Call to: ClientController.addClient()");
        ClientResponse response = null;
        try {
            Future<ClientResponse> result = this.addClient.execute(request);
            response = result.get();
        }
        catch (Exception e){
            log.error("Error in: ClientController.addClient()", e);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ClientResponse> deleteClient(@RequestBody DeleteClientRequest request){
        log.info("Call to: ClientController.deleteClient()");
        try {
            this.deleteClient.execute(request);
        }
        catch (Exception e){
            log.error("Error in: ClientController.deleteClient()", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<ClientResponse> updateClient(@RequestBody UpdateClientRequest request){
        log.info("Call to: ClientController.updateClient()");
        ClientResponse response = null;
        try {
            Future<ClientResponse> result = this.updateClient.execute(request);
            response = result.get();
        }
        catch (Exception e){
            log.error("Error in: ClientController.updateClient()", e);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
