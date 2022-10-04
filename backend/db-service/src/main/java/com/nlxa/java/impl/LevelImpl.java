package com.nlxa.java.impl;

import com.nlxa.java.connector.IConnector;
import com.nlxa.java.domain.Level;

public interface LevelImpl extends IConnector<Level, String> {

    Boolean verifyValueID(String id);
}
