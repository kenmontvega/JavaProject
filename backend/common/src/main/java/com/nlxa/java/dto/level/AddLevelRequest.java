package com.nlxa.java.dto.level;

import com.nlxa.java.domain.Level;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class AddLevelRequest implements Serializable {

    private String description;

    public AddLevelRequest() {}

    public AddLevelRequest(String description) {
        this.description=description;
    }
}
