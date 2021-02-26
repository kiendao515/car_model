package service_impl;

import dao.UserDao;
import dao_impl.UserDaoImpl;
import entity.Account;
import service.ProductService;
import service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    UserDao userDao= new UserDaoImpl();
    @Override
    public Account getAccount(String username, String password) throws SQLException, ClassNotFoundException {
        return (username!=null&&password !=null) ? userDao.getAccount(username,password) : null;
    }

    @Override
    public boolean checkUserExist(String username) throws SQLException, ClassNotFoundException {
        return userDao.checkUserExist(username);
    }

    @Override
    public void register(String username, String password,String gmail) throws SQLException, ClassNotFoundException {
        userDao.register(username,password,gmail);
    }

    @Override
    public void deleteProduct(int id) throws SQLException, ClassNotFoundException {
        userDao.deleteProduct(id);
    }

    @Override
    public void insertProduct(String name, String ratio, double price, String image, int brandID, String description, int sellerID)
            throws SQLException, ClassNotFoundException {
         userDao.insertProduct(name,ratio,price,image,brandID,description,sellerID);
    }

    @Override
    public void updateProduct(String name, String ratio, double price, String image, int brandID, String description, int id) throws SQLException, ClassNotFoundException {
        userDao.updateProduct(name,ratio,price,image,brandID,description,id);
    }

    @Override
    public void insertOrder(String orderID, String name, String tel, String address) throws SQLException, ClassNotFoundException {
        userDao.insertOrder(orderID,name,tel,address);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductService productService= new ProductServiceImpl();
        System.out.println(productService.getProductBySellerID(1));
    }
}
