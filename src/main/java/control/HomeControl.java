package control;

import dao.ProductDao;
import dao_impl.ProductDaoImpl;
import entity.Category;
import entity.Product;
import service.CategoryService;
import service.ProductService;
import service_impl.CategoryServiceImpl;
import service_impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeControl extends HttpServlet {
    ProductService productService= new ProductServiceImpl();
    CategoryService categoryService= new CategoryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            String id=request.getParameter("id");
            if(id==null){
                id="1";
            }
            List<Product> productList= productService.findAllProduct();// get data from dao
            List<Category> listC=categoryService.findAllProduct();
            Product newestProduct = productService.getNewestProduct();
            ProductDaoImpl productDao= new ProductDaoImpl();
            List<Product> list=productService.getProductEachPage(Integer.parseInt(id));// get product from dao with paging split
            int count= productDao.numberPage();
            request.setAttribute("count",count);
//            System.out.println(list);
            // set data to jsp
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("listProduct",list);
            request.setAttribute("listCategory",listC);
            request.setAttribute("newestProduct",newestProduct);
//            response.getWriter().println(list.toString());
            request.getRequestDispatcher("/Home.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
