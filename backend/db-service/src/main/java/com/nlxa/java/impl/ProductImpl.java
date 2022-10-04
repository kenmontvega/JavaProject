package com.nlxa.java.impl;

import com.nlxa.java.connector.IConnector;
import com.nlxa.java.domain.Product;

public interface ProductImpl extends IConnector<Product, String> {

    Boolean verifyValueID(String product_id);
}
