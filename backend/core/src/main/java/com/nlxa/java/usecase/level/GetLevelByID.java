package com.nlxa.java.usecase.level;

import com.nlxa.java.dto.level.GetLevelIdRequest;
import com.nlxa.java.dto.level.LevelResponse;
import com.nlxa.java.error.RequestException;
import com.nlxa.java.level.LevelBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GetLevelByID {

    private LevelBusiness levelBusiness;

    @Autowired
    public GetLevelByID(LevelBusiness levelBusiness) {
        this.levelBusiness = levelBusiness;
    }

    public LevelResponse execute(GetLevelIdRequest request){
        log.info("Call to: GetLevelByID.execute()");
        LevelResponse response = null;
        String verifyInfo = verifyRequestInfo(request);
        if (verifyInfo.equals("")) {
            response = this.levelBusiness.getByID(request);
        } else {
            log.error("Error in: GetLevelByID.execute() -> Verify if th information is complete");
            throw new RequestException(verifyInfo, "Error in: GetLevelByID.execute() -> Verify if th information is complete");
        }
        return response;
    }


    private String verifyRequestInfo(GetLevelIdRequest request){
        log.info("Call to: LevelBusiness.verifyRequestInfo()");
        String result = "";
        if (request == null || request.getId() == null){
            log.warn("Warn: The request or the request info is null");
            result = "Warn: The request or the request info is null";
        } else if (request.getId().equals("")) {
            log.warn("Warn: The request info is empty");
            result = "Warn: The request info is empty";
        }
        return result;
    }
}
