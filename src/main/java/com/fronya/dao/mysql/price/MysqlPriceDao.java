package com.fronya.dao.mysql.price;


import com.fronya.dao.mysql.connection.ConnectionPool;
import com.fronya.dao.price.PriceDao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Class for work with database
 */
public class MysqlPriceDao implements PriceDao {
    private static final Logger log = Logger.getLogger(MysqlPriceDao.class);

    private static final String PATH_FILE = "database";
    private static final String COLUMN_VALUE = "value";

    private static final String KEY_GET= "price.get";
    private static final String KEY_CREATE = "price.create";
    private static final String KEY_DELETE = "price.delete";
    private static final String KEY_UPDATE = "price.update";

    private static String queryGet;
    private static String queryCreate;
    private static String queryDelete;
    private static String queryUpdate;

    static {
        ResourceBundle resource = ResourceBundle.getBundle(PATH_FILE);
        queryGet = resource.getString(KEY_GET);
        queryCreate = resource.getString(KEY_CREATE);
        queryDelete= resource.getString(KEY_DELETE);
        queryUpdate = resource.getString(KEY_UPDATE);
    }


    public int create(double newPrice) {
        int newId = -1;
        Connection con = ConnectionPool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(queryCreate)){
            stmt.setDouble(1, newPrice);
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()) {
                    newId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            log.debug(e.getMessage());
        }
        return newId;
    }

    public boolean delete(int id) {
        boolean isDelete = false;
        Connection con = ConnectionPool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(queryDelete)) {
            stmt.setInt(1, id);

            if(stmt.executeUpdate() != 0){
                isDelete = true;
            }
        }catch (SQLException e) {
            log.debug(e.getMessage());
        }
        return isDelete;
    }

    public boolean update(int id, double price) {
        boolean isUpdate = false;
        Connection con = ConnectionPool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(queryUpdate)) {
            stmt.setDouble(1, price);
            stmt.setInt(2, id);

            if(stmt.executeUpdate() != 0){
                isUpdate = true;
            }
        }catch (SQLException e) {
            log.debug(e.getMessage());
        }
        return isUpdate;
    }

    public double get(int id) {
        double findPrice = -1;
        Connection con = ConnectionPool.getConnection();
        try(PreparedStatement stmt = con.prepareStatement(queryGet)) {
            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()) {
                    findPrice = rs.getDouble(COLUMN_VALUE);
                }
            }
        }catch (SQLException e) {
            log.debug("Product " + id + " not find " + e.getMessage());
        }
        return findPrice;
    }
}
