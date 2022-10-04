package com.nlxa.java.dto.client;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import java.io.Serializable;

@Slf4j
@Data
public class AddClientRequest implements Serializable {

    private String firstName;
    private String lastName;

    public AddClientRequest() {
    }

    public AddClientRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
