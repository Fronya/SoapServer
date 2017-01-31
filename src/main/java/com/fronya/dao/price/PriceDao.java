package com.fronya.dao.price;

/**
 * Interface that all PriceDAOs must support
 */
public interface PriceDao {
    int create(double newPrice);
    boolean delete(int id);
    boolean update(int id, double price);
    double get(int id);
}
