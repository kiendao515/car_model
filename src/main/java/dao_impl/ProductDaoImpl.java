package dao_impl;

import dao.ProductDao;
import entity.Account;
import entity.MyConnection;
import entity.Product;
import service.ProductService;
import service_impl.ProductServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    MyConnection myConnection= new MyConnection();
    @Override
    public List<Product> getAllProduct() throws SQLException, ClassNotFoundException {
        List<Product> list= new ArrayList<>();
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from product2");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            Product product= new Product(resultSet.getInt("id"),resultSet.getString("name"),
                    resultSet.getString("ratio"),resultSet.getDouble("price"),resultSet.getString("description"),
                    resultSet.getString("image"));
            list.add(product);
        }
        return list;
    }

    @Override
    public Product getNewestProduct() throws SQLException, ClassNotFoundException {
        Product product=null;
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT  * from product2 order by id desc limit 1");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            product= new Product(resultSet.getInt("id"),resultSet.getString("name"),
                    resultSet.getString("ratio"), resultSet.getDouble("price"),
                    resultSet.getString("description"),
                    resultSet.getString("image"));
        }
        return product;
    }

    @Override
    public List<Product> getListProductByBrandID(int brandID) throws ClassNotFoundException, SQLException {
        List<Product> list= new ArrayList<>();
        Connection connection= myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from product2 where brandID=?");
        preparedStatement.setInt(1,brandID);
        ResultSet rs= preparedStatement.executeQuery();
        while(rs.next()){
            Product product = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("ratio")
                    ,rs.getDouble("price"),rs.getString("description"),rs.getString("image"));
            list.add(product);
        }
        return list;
    }

    @Override
    public Product getDetailProduct(int id) throws SQLException, ClassNotFoundException {
        Product product=null;
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT  * from product2 where id =?");
        preparedStatement.setInt(1,id);
        ResultSet rs=preparedStatement.executeQuery();
        while(rs.next()){
            product= new Product(rs.getInt(1),rs.getString(2),rs.getString(3)
                    ,rs.getDouble(4),rs.getString(7),rs.getString(5));
        }
        return product;
    }

    @Override
    public List<Product> getProductSearched(String text) throws SQLException, ClassNotFoundException {
         List<Product> list= new ArrayList<>();
        Connection connection= myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM `product2` where name like ?");
        preparedStatement.setString(1,"%"+text+"%");
        ResultSet rs= preparedStatement.executeQuery();
        while(rs.next()){
            Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3)
                    ,rs.getDouble(4),rs.getString(7),rs.getString(5));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> getProductBySellerID(int id) throws SQLException, ClassNotFoundException {
        List<Product> list= new ArrayList<>();
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from product2 where sellerID=?");
        preparedStatement.setInt(1,id);
        ResultSet rs= preparedStatement.executeQuery();
        while(rs.next()){
            Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3)
                    ,rs.getDouble(4),rs.getString(7),rs.getString(5));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> getProductEachPage(int index) throws SQLException, ClassNotFoundException {
        List<Product> list= new ArrayList<>();
        Connection connection=myConnection.connectDb();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * from `product2` order by `id` limit 10 \n" +
                " offset ?;\n");
        preparedStatement.setInt(1,(index-1)*10);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            Product product= new Product(resultSet.getInt("id"),resultSet.getString("name"),
                    resultSet.getString("ratio"),resultSet.getDouble("price"),resultSet.getString("description"),
                    resultSet.getString("image"));
            list.add(product);
        }
        return list;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductService productService= new ProductServiceImpl();
//        System.out.println(productService.findAllProduct());
//        System.out.println(productService.getNewestProduct());
//        System.out.println(productService.getListProductByBrandID(1));
//        System.out.println(productService.getProductSearched("VIOS"));
        System.out.println(productService.getProductEachPage(1).get(1).getId());
    }

    public int numberPage() throws SQLException, ClassNotFoundException {
        Connection connection= myConnection.connectDb();
        int count=0;
        PreparedStatement preparedStatement=connection.prepareStatement("select count(*) from product2");
        ResultSet rs= preparedStatement.executeQuery();
        while(rs.next()){
             count =rs.getInt(1);

        }
         int numberPage = count / 10;
         if(count%10!=0){
             numberPage++;
         }
         return numberPage;


    }
}
