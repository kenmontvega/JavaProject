package com.nlxa.java.jpa;

import com.nlxa.java.domain.Level;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.impl.LevelImpl;
import com.nlxa.java.repository.LevelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class LevelJPAComponent implements LevelImpl {

    private LevelRepository levelRepository;

    @Autowired
    public LevelJPAComponent(LevelRepository levelRepository){
        this.levelRepository = levelRepository;
    }

    @Override
    public List<Level> getAll() {
        log.info("Call to: LevelJPAComponent.getAll()");
        List<Level> response = null;
        try {
            response = this.levelRepository.findAll();
        } catch (Exception e){
            log.error("Error in: LevelJPAComponent.getAll() -> " + e.getMessage(), e);
        }
        return response;
    }

    @Override
    public Level getById(String s) {
        log.info("Call to: LevelJPAComponent.getById()");
        Level response = null;
        try {
            response = this.levelRepository.findById(s).orElse(null); //como es un optional le ponemos que retorne uno o nulo
        } catch (Exception e){
            log.error("Error in: LevelJPAComponent.getById() -> " + e.getMessage(), e);
            throw new RequestException("Error in: LevelJPAComponent.getById()", e.getMessage());
        }
        return response;
    }

    @Override
    public Level save(Level type) {
        log.info("Call to: LevelJPAComponent.save()");
        Level response = null;
        try {
            response = this.levelRepository.save(type);
        } catch (Exception e){
            log.error("Error in: LevelJPAComponent.save() -> " + e.getMessage(), e);
        }
        return response;
    }

    @Override
    public Level update(Level type) {
        log.info("Call to: LevelJPAComponent.update()");
        Level response = null;
        try {
            response = this.levelRepository.save(type);
        } catch (Exception e){
            log.error("Error in: LevelJPAComponent.update() -> " + e.getMessage(), e);
        }
        return response;
    }

    @Override
    public void delete(Level type) {
        log.info("Call to: LevelJPAComponent.delete()");
        try {
            this.levelRepository.delete(type);
        } catch (Exception e){
            log.error("Error in: LevelJPAComponent.delete() -> " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteById(String s) {
        log.info("Call to: LevelJPAComponent.deleteById()");
        try {
            this.levelRepository.deleteById(s);
        } catch (Exception e){
            log.error("Error in: LevelJPAComponent.delete() -> " + e.getMessage(), e);
        }
    }

    //???
    @Override
    public Boolean verifyValueID(String id) {
        /*log.info("Call to: LevelJPAComponent.verifyValueID()");
        boolean response = false;
        try {
            response = this.levelRepository.existsById(id);
        } catch (Exception e){
            log.error("Error in: LevelJPAComponent.delete() -> " + e.getMessage(), e);
        }
        return response;*/
        return null;
    }
}
