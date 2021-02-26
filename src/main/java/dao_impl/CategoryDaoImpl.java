package dao_impl;

import dao.CategoryDao;
import entity.Category;
import entity.MyConnection;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    MyConnection myConnection= new MyConnection();
    @Override
    public List<Category> getAllProduct() throws SQLException, ClassNotFoundException {
        List<Category> list = new ArrayList<>();
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement =connection.prepareStatement("select * from brand order by name asc");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            Category category= new Category(resultSet.getInt("id"),resultSet.getString("name"));
            list.add(category);
        }
        return list;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CategoryDao categoryDao= new CategoryDaoImpl();
        List<Category> list= categoryDao.getAllProduct();
        for (Category c:list) {
            System.out.println(c.getName());
        }
    }
}
