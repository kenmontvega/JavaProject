package com.nlxa.java.level;

import com.nlxa.java.domain.Level;
import com.nlxa.java.dto.level.*;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.jpa.LevelJPAComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LevelBusiness {

    private LevelJPAComponent levelJPAComponent;

    @Autowired
    public LevelBusiness(LevelJPAComponent levelJPAComponent){
        this.levelJPAComponent = levelJPAComponent;
    }

    public LevelListResponse getAllLevels(){
        log.info("Call to: LevelBusiness.getAllLevels()");
        LevelListResponse response = null;
        try {
            response = new LevelListResponse();
            List<Level> levels = this.levelJPAComponent.getAll();

            for (Level levelAux : levels){
                response.getLevelResponseList().add(new LevelResponse(levelAux));
            }
        } catch (Exception e) {
            log.error("Error in: LevelBusiness.getAllLevels() -> Verify that the connection is correct");
        }

        return response;
    }

    public LevelResponse getByID(GetLevelIdRequest request){
        log.info("Call to: LevelBusiness.getByID()");
        LevelResponse response = null;
        try{
            Level level = this.levelJPAComponent.getById(request.getId());
            response = new LevelResponse(level);
        } catch (RequestException e){
            log.error("Error in: LevelBusiness.getByID()", e);
            throw e;
        } catch (Exception e) {
            log.error("Error in: LevelBusiness.getByID() -> Verify that the connection is correct");
            throw new RequestException("Error in: LevelBusiness.getByID()", e.getMessage());
        }
        return response;
    }

    public LevelResponse addLevel(AddLevelRequest request){
        log.info("Call to: LevelBusiness.addLevel()");
        LevelResponse response = null;
        try {
            Level level = this.levelJPAComponent.save(new Level(request));
            response = new LevelResponse(level);
        } catch (Exception e) {
            log.error("Error in: LevelBusiness.addLevel() -> Verify that the connection is correct");
        }
        return response;
    }

    public void deleteLevel(DeleteLevelRequest request){
        log.info("Call to: LevelBusiness.deleteLevel()");
        try {
            this.levelJPAComponent.delete(new Level(request));
        } catch (Exception e) {
            log.error("Error in: LevelBusiness.deleteLevel() -> Verify that the connection is correct");
        }
    }

    public void deleteLevelById(DeleteLevelByIdRequest request){
        log.info("Call to: LevelBusiness.deleteLevelById()");
        try {
            this.levelJPAComponent.deleteById(request.getId());
        } catch (Exception e) {
            log.error("Error in: LevelBusiness.deleteLevelById() -> Verify that the connection is correct");
        }
    }

    public LevelResponse updateLevel(UpdateLevelRequest request){
        log.info("Call to: LevelBusiness.updateLevel()");
        LevelResponse response = null;
        try {
            Level level = this.levelJPAComponent.update(new Level(request));
            response = new LevelResponse(level);
        } catch (Exception e) {
            log.error("Error in: LevelBusiness.updateLevel() -> Verify that the connection is correct");
        }
        return response;
    }

}
