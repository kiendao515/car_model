package dao_impl;

import dao.UserDao;
import entity.Account;
import entity.MyConnection;
import service.UserService;
import service_impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserDaoImpl implements UserDao {
    MyConnection myConnection= new MyConnection();
    @Override
    public Account getAccount(String username, String password) throws SQLException, ClassNotFoundException {
        Account account= null;
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement =connection.prepareStatement("select * from user2 where `username`=? and `password`=?");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet rs= preparedStatement.executeQuery();
        if(rs.next()){
            account= new Account(rs.getInt(1),rs.getString(2),rs.getString(3),
                    rs.getInt(4),rs.getInt(5));
        }
        return account;
    }

    @Override
    public boolean checkUserExist(String username) throws SQLException, ClassNotFoundException {
        boolean rs=false;
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from user2 where username=?");
        preparedStatement.setString(1,username);
        ResultSet resultSet= preparedStatement.executeQuery();
        if(resultSet!=null){
            rs=true;
        }
        return rs;
    }

    @Override
    public void register(String username, String password,String gmail) throws SQLException, ClassNotFoundException {
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into user2(username,password,sellID,adminID,gmail) values (?,?,0,0,?)");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,gmail);
        if(preparedStatement.executeUpdate()!=0){
            System.out.println("them thanh cong");
        }

    }

    @Override
    public void deleteProduct(int id) throws SQLException, ClassNotFoundException {
        Connection connection= myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("delete from product2 where id =? ");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void insertProduct(String name, String ratio, double price, String image, int brandID, String description, int sellerID)
            throws SQLException, ClassNotFoundException {
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into product2(name,ratio,price,image,brandID," +
                "description,sellerID) values (?,?,?,?,?,?,?)");
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,ratio);
        preparedStatement.setDouble(3,price);
        preparedStatement.setString(4,image);
        preparedStatement.setInt(5,brandID);
        preparedStatement.setString(6,description);
        preparedStatement.setInt(7,sellerID);
        if( preparedStatement.executeUpdate()!=0){
            System.out.println("insert thanh cong");
        }
    }

    @Override
    public void updateProduct(String name, String ratio, double price, String image, int brandID, String description,int id) throws SQLException, ClassNotFoundException {
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("update product2 set name=?,ratio=?,price=?,image=?,brandID=?,description=?" +
                        "where id=?");
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,ratio);
        preparedStatement.setDouble(3,price);
        preparedStatement.setString(4,image);
        preparedStatement.setInt(5,brandID);
        preparedStatement.setString(6,description);
        preparedStatement.setInt(7,id);
        if( preparedStatement.executeUpdate()!=0){
            System.out.println("update thanh cong");
        }
    }

    @Override
    public void insertOrder(String orderID, String name, String tel, String address) throws SQLException, ClassNotFoundException {
        Connection connection= myConnection.connectDb();
        PreparedStatement preparedStatemen=connection.prepareStatement("insert into order2(orderID,name,tel,address) values(?,?,?,?)");
        preparedStatemen.setString(1,orderID);
        preparedStatemen.setString(2,name);
        preparedStatemen.setString(3,tel);
        preparedStatemen.setString(4,address);
        if(preparedStatemen.executeUpdate()!=0){
            System.out.println("insert thành công !!");
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao= new UserDaoImpl();
        UserService userService= new UserServiceImpl();
        System.out.println(userDao.getAccount("kiendao","kiendao2001"));
        System.out.println("--");
        System.out.println(userService.getAccount("kiendao","kiendao2001"));
        System.out.println(userService.checkUserExist("kiendao"));
        String uniqueID = UUID.randomUUID().toString();
        System.out.println(uniqueID);
//        System.out.println(userService.updateProduct("a","1:12","100","sh","1","shs",1));
//        userService.register("admin","kiendao2001","daotrungkien515@gmail.com");
    }
}
