package com.nlxa.java.usecase.level;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.level.LevelResponse;
import com.nlxa.java.dto.level.UpdateLevelRequest;
import com.nlxa.java.level.LevelBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class UpdateLevel {

    private LevelBusiness levelBusiness;

    @Autowired
    public UpdateLevel(LevelBusiness levelBusiness) {
        this.levelBusiness = levelBusiness;
    }

    @Async
    public Future<LevelResponse> execute(UpdateLevelRequest request){
        log.info("Call to: UpdateLevel.execute()");
        AsyncResponse<LevelResponse> response = null;
        try {
            response = new AsyncResponse<>(this.levelBusiness.updateLevel(request));
        } catch (Exception e){
            log.error("Error in: UpdateLevel.execute()", e);
        }
        return response;
    }
}