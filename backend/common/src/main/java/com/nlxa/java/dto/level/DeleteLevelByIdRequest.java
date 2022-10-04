package com.nlxa.java.dto.level;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class DeleteLevelByIdRequest implements Serializable {

    private String id;

    public DeleteLevelByIdRequest() {
    }

    public DeleteLevelByIdRequest(String id) {
        this.id = id;
    }
}
