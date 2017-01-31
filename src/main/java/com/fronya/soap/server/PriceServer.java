package com.fronya.soap.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PriceServer {

    @WebMethod
    int createPrice(double value);

    @WebMethod
    boolean updatePrice(int id, double newValue);

    @WebMethod
    boolean deletePrice(int id);

    @WebMethod
    double getPrice(int id);
}
