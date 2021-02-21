package dao;

import entity.Account;
import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> getAllProduct() throws SQLException, ClassNotFoundException;
    Product getNewestProduct() throws  SQLException,ClassNotFoundException;
    // ham de tra ve product theo brandID
    List<Product> getListProductByBrandID(int brandID) throws ClassNotFoundException,SQLException;

    // detail product
    Product getDetailProduct(int id) throws SQLException,ClassNotFoundException;

    //search sp
    List<Product> getProductSearched(String text) throws SQLException,ClassNotFoundException;

    List<Product> getProductBySellerID(int id) throws SQLException,ClassNotFoundException;
}
