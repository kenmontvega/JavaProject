package com.nlxa.java.usecase.level;

import com.nlxa.java.dto.level.DeleteLevelByIdRequest;
import com.nlxa.java.level.LevelBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteLevelById {

    private LevelBusiness levelBusiness;

    @Autowired
    public DeleteLevelById(LevelBusiness levelBusiness) {
        this.levelBusiness = levelBusiness;
    }

    @Async
    public void execute(DeleteLevelByIdRequest request){
        log.info("Call to: DeleteLevelById.execute()");
        try {
            this.levelBusiness.deleteLevelById(request);
        } catch (Exception e){
            log.error("Error in: DeleteLevelById.execute()", e);
        }
    }
}
