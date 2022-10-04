package com.nlxa.java.controller;

import com.nlxa.java.dto.level.*;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.usecase.level.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping(value = "/level")
public class LevelController {

    private GetAllLevels getAllLevels;
    private GetLevelByID getLevelByID;
    private AddLevel addLevel;
    private DeleteLevel deleteLevel;
    private DeleteLevelById deleteLevelById;
    private UpdateLevel updateLevel;

    @Autowired
    public LevelController(GetAllLevels getAllLevels, 
                           GetLevelByID getLevelByID,
                           AddLevel addLevel,
                           DeleteLevel deleteLevel,
                           DeleteLevelById deleteLevelById,
                           UpdateLevel updateLevel){
        this.getAllLevels = getAllLevels;
        this.getLevelByID = getLevelByID;
        this.addLevel = addLevel;
        this.deleteLevel = deleteLevel;
        this.deleteLevelById = deleteLevelById;
        this.updateLevel = updateLevel;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<LevelListResponse> getAllLevels() {
        log.info("Call to: LevelController.getAllLevels()");
        LevelListResponse response = null;
        try {
            Future<LevelListResponse> result =this.getAllLevels.execute();
            response = result.get();
        } catch (Exception e){
            log.error("Error in: LevelController.getAllLevels()", e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/byId")
    public LevelResponse getLevelByID(@RequestBody GetLevelIdRequest request) {
        log.info("Call to: LevelController.getLevelByID()");
        LevelResponse response = null;
        try {
            response = this.getLevelByID.execute(request);
        } catch (RequestException  e){
            log.error("Error in: LevelController.getLevelByID() ->", e);
            throw e;
        } catch (Exception e){
            log.error("Error in: LevelController.getLevelByID() ->", e);
            throw new RequestException(e.getCause().getMessage(), "Error in: LevelController.getLevelByID()");
        }
        return response;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<LevelResponse> addLevel(@RequestBody AddLevelRequest request){
        log.info("Call to: LevelController.addLevel()");
        LevelResponse response = null;
        try {
            Future<LevelResponse> result = this.addLevel.execute(request);
            response = result.get();
        }
        catch (Exception e){
            log.error("Error in: LevelController.addLevel()", e);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<LevelResponse> deleteLevel(@RequestBody DeleteLevelRequest request){
        log.info("Call to: LevelController.deleteLevel()");
        try {
            this.deleteLevel.execute(request);
        }
        catch (Exception e){
            log.error("Error in: LevelController.deleteLevel()", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<LevelResponse> deleteLevelById(@RequestBody DeleteLevelByIdRequest request){
        log.info("Call to: LevelController.deleteLevelById()");
        try {
            this.deleteLevelById.execute(request);
        }
        catch (Exception e){
            log.error("Error in: LevelController.deleteLevelById()", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<LevelResponse> updateLevel(@RequestBody UpdateLevelRequest request){
        log.info("Call to: LevelController.updateLevel()");
        LevelResponse response = null;
        try {
            Future<LevelResponse> result = this.updateLevel.execute(request);
            response = result.get();
        }
        catch (Exception e){
            log.error("Error in: LevelController.updateLevel()", e);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
