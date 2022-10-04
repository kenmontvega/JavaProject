package com.nlxa.java.dto.client;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class GetClientByIdRequest implements Serializable {

    private String client_id;

    public GetClientByIdRequest() {
    }
}
