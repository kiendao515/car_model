package service_impl;

import dao.ProductDao;
import dao_impl.ProductDaoImpl;
import entity.Product;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao= new ProductDaoImpl();
    @Override
    public List<Product> findAllProduct() throws SQLException, ClassNotFoundException {
        return productDao.getAllProduct();
    }

    @Override
    public Product getNewestProduct() throws SQLException, ClassNotFoundException {
        return productDao.getNewestProduct();
    }

    @Override
    public List<Product> getListProductByBrandID(int brandID) throws ClassNotFoundException, SQLException {
        return productDao.getListProductByBrandID(brandID);
    }

    @Override
    public Product getDetailProduct(int id) throws ClassNotFoundException, SQLException {
        return productDao.getDetailProduct(id);
    }

    @Override
    public List<Product> getProductSearched(String text) throws ClassNotFoundException, SQLException {
        return productDao.getProductSearched(text);
    }

    @Override
    public List<Product> getProductBySellerID(int id) throws ClassNotFoundException, SQLException {
        return productDao.getProductBySellerID(id);
    }

    @Override
    public List<Product> getProductEachPage(int index) throws ClassNotFoundException, SQLException {
        return productDao.getProductEachPage(index);
    }
}
