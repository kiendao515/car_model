package entity;

import common.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection connection=null;
    public void driverTest() throws ClassNotFoundException{
        try{
            Class.forName(AppConfig.DRIVER);
            System.out.println("Library existed");
        }catch(ClassNotFoundException e){
            throw new ClassNotFoundException("JDBC DRiver is not found" +e.getMessage());
        }
    }
    public Connection connectDb() throws ClassNotFoundException, SQLException {
        driverTest();
        try{
            connection= DriverManager.getConnection(AppConfig.URL_DATABASE, AppConfig.USERNAME, AppConfig.PASSWORD);
            if(connection!=null){
                System.out.println("Ket noi database thanh cong");
            }
        }catch(SQLException e){
            throw new SQLException("Khong the ket noi jdbc");
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MyConnection myConnection= new MyConnection();
        myConnection.connectDb();
    }
}
