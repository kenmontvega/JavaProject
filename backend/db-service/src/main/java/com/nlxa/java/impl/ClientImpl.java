package com.nlxa.java.impl;

import com.nlxa.java.connector.IConnector;
import com.nlxa.java.domain.Client;

public interface ClientImpl  extends IConnector<Client, String> {

    Boolean verifyValueID(String client_id);
}
