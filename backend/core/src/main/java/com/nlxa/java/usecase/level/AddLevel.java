package com.nlxa.java.usecase.level;

import com.nlxa.java.config.AsyncResponse;
import com.nlxa.java.dto.level.AddLevelRequest;
import com.nlxa.java.dto.level.LevelResponse;
import com.nlxa.java.level.LevelBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AddLevel {

    private LevelBusiness levelBusiness;

    @Autowired
    public AddLevel(LevelBusiness levelBusiness) {
        this.levelBusiness = levelBusiness;
    }

    @Async
    public Future<LevelResponse> execute(AddLevelRequest request){
        log.info("Call to: AddLevel.execute()");
        AsyncResponse<LevelResponse> response = null;
        try {
            response = new AsyncResponse<>(this.levelBusiness.addLevel(request));
        } catch (Exception e){
            log.error("Error in: AddLevel.execute()", e);
        }
        return response;
    }
}
