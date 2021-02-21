package service;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> findAllProduct() throws SQLException, ClassNotFoundException;
    Product getNewestProduct() throws  SQLException,ClassNotFoundException;
    List<Product> getListProductByBrandID(int brandID) throws ClassNotFoundException,SQLException;
    Product getDetailProduct(int id) throws ClassNotFoundException,SQLException;
    List<Product> getProductSearched(String text) throws ClassNotFoundException,SQLException;
    List<Product> getProductBySellerID(int id) throws  ClassNotFoundException,SQLException;
}
