package com.nlxa.java.dto.client;

import com.nlxa.java.domain.Client;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class ClientResponse implements Serializable {

    private String client_id;
    private String firstName;
    private String lastName;

    public ClientResponse() {
    }

    public ClientResponse(Client client) {toClientResponse(client);}

    public void toClientResponse(Client client) {
        setClient_id((client.getClient_id()));
        setFirstName(client.getFirstName());
        setLastName(client.getLastName());
    }
}
