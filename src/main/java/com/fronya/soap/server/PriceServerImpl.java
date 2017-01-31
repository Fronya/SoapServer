package com.fronya.soap.server;


import com.fronya.dao.factory.FactoryDao;
import com.fronya.dao.price.PriceDao;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class PriceServerImpl implements PriceServer{
    private PriceDao priceDao = FactoryDao.getDAOFactory(FactoryDao.MYSQL).getPriceDao();

    @WebMethod
    public int createPrice(double value) {
        return priceDao.create(value);
    }

    @WebMethod
    public boolean updatePrice(int id, double newValue) {
        return priceDao.update(id, newValue);
    }

    @WebMethod
    public boolean deletePrice(int id) {
        return priceDao.delete(id);
    }

    @WebMethod
    public double getPrice(int id) {
        return priceDao.get(id);
    }
}
