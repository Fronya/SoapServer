package com.fronya.dao.factory;

import com.fronya.dao.mysql.factory.MysqlFactoryDao;
import com.fronya.dao.price.PriceDao;

/**
 * Abstract class
 */
public abstract class FactoryDao {
    //List of DAO types supported by the factory
    public static final int MYSQL = 1;

    public abstract PriceDao getPriceDao();

    public static FactoryDao getDAOFactory(int whichFactory){
        switch (whichFactory){
            case MYSQL:
                return new MysqlFactoryDao();
            default:
                return null;
        }
    }

}
