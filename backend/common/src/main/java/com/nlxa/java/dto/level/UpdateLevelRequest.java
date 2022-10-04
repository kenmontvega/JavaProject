package com.nlxa.java.dto.level;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class UpdateLevelRequest implements Serializable {

    private String id;
    private String description;

    public UpdateLevelRequest() {
    }

    public UpdateLevelRequest(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
