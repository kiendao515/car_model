package service;

import entity.Account;

import java.sql.SQLException;

public interface UserService {
    Account getAccount(String username,String password) throws SQLException,ClassNotFoundException;
    boolean checkUserExist(String username) throws SQLException,ClassNotFoundException;
    void register(String username, String password,String gmail) throws SQLException,ClassNotFoundException;

    void deleteProduct(int id) throws SQLException,ClassNotFoundException;
    void insertProduct(String name,String ratio,double price,String image,int brandID,String description,int sellerID)
            throws SQLException,ClassNotFoundException;
    void updateProduct(String name,String ratio,double price,String image,int brandID,String description,int id)
            throws SQLException,ClassNotFoundException;

    void insertOrder(String orderID,String name,String tel,String address) throws SQLException,ClassNotFoundException;
}
