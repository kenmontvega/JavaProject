package com.nlxa.java.dto.client;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import java.io.Serializable;

@Slf4j
@Data
public class UpdateClientRequest implements Serializable {

    private String client_id;
    private String firstName;
    private String lastName;

    public UpdateClientRequest() {
    }

    public UpdateClientRequest(String client_id, String firstName, String lastName) {
        this.client_id = client_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
