package com.nlxa.java.dto.level;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class GetLevelIdRequest implements Serializable{

    private String id;

    public GetLevelIdRequest() {
    }
}
