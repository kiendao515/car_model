package service;

import entity.Category;
import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    List<Category> findAllProduct() throws SQLException, ClassNotFoundException;

}
