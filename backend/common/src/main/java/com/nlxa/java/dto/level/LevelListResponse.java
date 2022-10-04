package com.nlxa.java.dto.level;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LevelListResponse {

    private List<LevelResponse> levelResponseList;

    public LevelListResponse() {
        this.levelResponseList = new ArrayList<>();
    }

    public LevelListResponse(List<LevelResponse> levelResponseList) {
        this.levelResponseList = levelResponseList;
    }

}
