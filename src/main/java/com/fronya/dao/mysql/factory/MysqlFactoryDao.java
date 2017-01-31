package com.fronya.dao.mysql.factory;


import com.fronya.dao.factory.FactoryDao;
import com.fronya.dao.mysql.price.MysqlPriceDao;
import com.fronya.dao.price.PriceDao;

public class MysqlFactoryDao extends FactoryDao{

    @Override
    public PriceDao getPriceDao() {
        return new MysqlPriceDao();
    }
}
