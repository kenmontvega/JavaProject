package com.nlxa.java.dto.client;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import java.io.Serializable;

@Slf4j
@Data
public class DeleteClientRequest implements Serializable {

    private String client_id;

    public DeleteClientRequest() {
    }

    public DeleteClientRequest(String client_id) {
        this.client_id = client_id;
    }
}
