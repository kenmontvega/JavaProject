package com.nlxa.java.usecase.level;

import com.nlxa.java.dto.level.DeleteLevelRequest;
import com.nlxa.java.level.LevelBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteLevel {

    private LevelBusiness levelBusiness;

    @Autowired
    public DeleteLevel(LevelBusiness levelBusiness) {
        this.levelBusiness = levelBusiness;
    }

    @Async
    public void execute(DeleteLevelRequest request){
        log.info("Call to: DeleteLevel.execute()");
        try {
            this.levelBusiness.deleteLevel(request);
        } catch (Exception e){
            log.error("Error in: GetAllLevels.execute()", e);
        }
    }
}
