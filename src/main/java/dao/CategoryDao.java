package dao;

import entity.Category;
import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> getAllProduct() throws SQLException, ClassNotFoundException;
}
