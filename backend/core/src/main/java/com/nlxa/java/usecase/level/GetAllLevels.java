package com.nlxa.java.usecase.level;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.level.LevelListResponse;
import com.nlxa.java.level.LevelBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class GetAllLevels {

    private LevelBusiness levelBusiness;

    @Autowired
    public GetAllLevels(LevelBusiness levelBusiness) {
        this.levelBusiness = levelBusiness;
    }

    @Async
    public Future<LevelListResponse> execute(){
        log.info("Call to: GetAllLevels.execute()");
        AsyncResponse<LevelListResponse> response = null;
        try {
            response = new AsyncResponse<>(this.levelBusiness.getAllLevels());
        } catch (Exception e){
            log.error("Error in: GetAllLevels.execute()", e);
        }
        return response;
    }
}
