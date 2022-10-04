package com.nlxa.java.dto.client;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class ClientListResponse {

    private List<ClientResponse> clientResponseList;

    public ClientListResponse() { this.clientResponseList = new ArrayList<>();}

    public ClientListResponse(List<ClientResponse> clientResponseList){
        this.clientResponseList = clientResponseList;
    }
}
