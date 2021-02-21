package service_impl;

import dao.CategoryDao;
import dao_impl.CategoryDaoImpl;
import entity.Category;
import service.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao= new CategoryDaoImpl();
    @Override
    public List<Category> findAllProduct() throws SQLException, ClassNotFoundException {
        return categoryDao.getAllProduct();
    }
}
